package com.josesanchez.geminiwrapper.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ChatClient chatClient(VertexAiGeminiChatModel vertexAiGeminiChatModel) {
        return ChatClient.create(vertexAiGeminiChatModel);
    }
}
