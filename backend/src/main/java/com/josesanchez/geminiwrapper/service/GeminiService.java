package com.josesanchez.geminiwrapper.service;

import com.josesanchez.geminiwrapper.model.GeminiRequest;
import com.josesanchez.geminiwrapper.model.GeminiResponse;

public interface GeminiService {
    GeminiResponse getResponse(GeminiRequest request);

    GeminiResponse getConversation(Long conversationId);

    GeminiResponse getAllConversation();
}
