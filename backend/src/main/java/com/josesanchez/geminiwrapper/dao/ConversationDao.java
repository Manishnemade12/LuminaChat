package com.josesanchez.geminiwrapper.dao;

import java.util.List;
import java.util.Optional;

import com.josesanchez.geminiwrapper.model.Conversation;

public interface ConversationDao {
    Conversation save(Conversation conversation);

    Optional<Conversation> findById(Long id);

    List<Conversation> findConversationChain(Long conversationId);

    List<Conversation> findAll();
}