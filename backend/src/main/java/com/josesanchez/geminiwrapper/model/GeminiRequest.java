package com.josesanchez.geminiwrapper.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request object for interacting with Gemini AI")
public class GeminiRequest {

    @Schema(description = "The text prompt to send to Gemini AI",
        example = "Explain quantum computing in simple terms")
    private String prompt;

    @Schema(description = "Optional ID of an existing conversation to continue. " +
        "Omit this field when starting a new conversation.",
        example = "42")
    private Long conversationId;
}
