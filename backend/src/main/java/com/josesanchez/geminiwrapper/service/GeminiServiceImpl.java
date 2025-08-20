package com.josesanchez.geminiwrapper.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.josesanchez.geminiwrapper.dao.ConversationDao;
import com.josesanchez.geminiwrapper.exception.BadRequestException;
import com.josesanchez.geminiwrapper.exception.DataAccessException;
import com.josesanchez.geminiwrapper.exception.ElementNotFoundException;
import com.josesanchez.geminiwrapper.exception.GeminiApiException;
import com.josesanchez.geminiwrapper.exception.ServiceException;
import com.josesanchez.geminiwrapper.mapper.GeminiMapper;
import com.josesanchez.geminiwrapper.model.Conversation;
import com.josesanchez.geminiwrapper.model.GeminiRequest;
import com.josesanchez.geminiwrapper.model.GeminiResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GeminiServiceImpl implements GeminiService {
    private final ConversationDao conversationDao;
    private final GeminiMapper geminiMapper;
    private final ChatClient chatClient;

    @Autowired
    public GeminiServiceImpl(ConversationDao conversationDao, GeminiMapper geminiMapper, ChatClient chatClient) {
        this.conversationDao = conversationDao;
        this.geminiMapper = geminiMapper;
        this.chatClient = chatClient;
    }

    @Override
    @Transactional
    public GeminiResponse getResponse(GeminiRequest request) {
        if (request == null || request.getPrompt() == null || request.getPrompt().trim().isEmpty()) {
            throw new BadRequestException("Request or prompt cannot be null or empty");
        }

        try {
            Conversation previousConversation = null;
            if (request.getConversationId() != null) {
                Optional<Conversation> convoOpt = conversationDao.findById(request.getConversationId());
                if (convoOpt.isPresent()) {
                    previousConversation = convoOpt.get();
                } else {
                    request.setConversationId(null);
                }
            }

            List<Message> messages = new ArrayList<>();
            if (previousConversation != null) {
                List<Conversation> conversationChain = conversationDao.findConversationChain(request.getConversationId());
                for (Conversation convo : conversationChain) {
                    messages.add(new UserMessage(convo.getPrompt()));
                    messages.add(new UserMessage(convo.getResponse()));
                }
            }
            messages.add(new UserMessage(request.getPrompt()));

            Prompt prompt = new Prompt(messages);
            var aiResponse = chatClient.prompt(prompt).call();

            String geminiResponse = aiResponse.content();
            if (geminiResponse == null || geminiResponse.trim().isEmpty()) {
                throw new GeminiApiException("Received empty response from Gemini AI");
            }

            Conversation newConversation = new Conversation(request.getPrompt(), geminiResponse, previousConversation);
            newConversation = conversationDao.save(newConversation);
            return geminiMapper.conversationToResponse(newConversation);

        } catch (GeminiApiException | BadRequestException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException("Error processing Gemini request: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public GeminiResponse getConversation(Long conversationId) {
        if (conversationId == null) {
            throw new BadRequestException("Conversation ID cannot be null");
        }

        try {
            if (conversationDao.findById(conversationId).isEmpty()) {
                throw new ElementNotFoundException("Conversation not found with ID: " + conversationId);
            }

            List<Conversation> conversationChain = conversationDao.findConversationChain(conversationId);
            return geminiMapper.conversationsToResponse(conversationChain);
        } catch (ElementNotFoundException | BadRequestException e) {
            throw e;
        } catch (Exception e) {
            throw new DataAccessException("Error retrieving conversation: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public GeminiResponse getAllConversation() {
        try {
            List<Conversation> conversationChain = conversationDao.findAll();
            return geminiMapper.conversationsToResponse(conversationChain);
        } catch (Exception e) {
            throw new DataAccessException("Error retrieving all conversations: " + e.getMessage(), e);
        }
    }
}
