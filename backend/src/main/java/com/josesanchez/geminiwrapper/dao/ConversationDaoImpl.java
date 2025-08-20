package com.josesanchez.geminiwrapper.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.josesanchez.geminiwrapper.model.Conversation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class ConversationDaoImpl implements ConversationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Conversation save(Conversation conversation) {
        entityManager.persist(conversation);
        return conversation;
    }

    @Override
    public Optional<Conversation> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Conversation.class, id));
    }


    @Override
    public List<Conversation> findConversationChain(Long conversationId) {
        List<Conversation> chain = new ArrayList<>();
        Optional<Conversation> current = findById(conversationId);

        while (current.isPresent()) {
            chain.add(current.get());
            current = Optional.ofNullable(current.get().getParentConversation());
        }
        // Reverse the list to have the conversation in chronological order (oldest first).
        java.util.Collections.reverse(chain);
        return chain;
    }

    @Override
    public List<Conversation> findAll() {
        TypedQuery<Conversation> query = entityManager.createQuery(
            "SELECT c FROM Conversation c ORDER BY c.createdAt", Conversation.class);
        return query.getResultList();
    }
}