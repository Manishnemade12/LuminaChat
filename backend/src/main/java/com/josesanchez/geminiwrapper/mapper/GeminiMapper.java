package com.josesanchez.geminiwrapper.mapper;

import java.util.List;

import com.josesanchez.geminiwrapper.model.Conversation;
import com.josesanchez.geminiwrapper.model.GeminiResponse;
import org.springframework.stereotype.Component;

@Component
public class GeminiMapper {

    public GeminiResponse conversationToResponse(Conversation conversation) {
        if (conversation == null) {
            return null;
        }
        GeminiResponse response = new GeminiResponse();
        response.setResponseText(conversation.getResponse());
        if (conversation.getParentConversation() != null) {
            response.setConversationId(conversation.getParentConversation().getId());
        }

        return response;
    }

    public GeminiResponse conversationsToResponse(List<Conversation> conversations) {
        if (conversations == null || conversations.isEmpty()) {
            return new GeminiResponse("", null, null); // Or handle as appropriate
        }

        // Assuming you want to return the *last* response in the chain
        Conversation lastConversation = conversations.get(conversations.size() - 1);

        GeminiResponse geminiResponse = new GeminiResponse();
        geminiResponse.setResponseText(lastConversation.getResponse());

        if (lastConversation.getParentConversation() != null) {
            geminiResponse.setConversationId(lastConversation.getParentConversation().getId());
        }

        geminiResponse.setConversations(conversations);

        return geminiResponse;
    }
}
