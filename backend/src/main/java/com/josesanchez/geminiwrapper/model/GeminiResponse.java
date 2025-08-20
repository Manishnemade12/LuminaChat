package com.josesanchez.geminiwrapper.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Response object from Gemini AI")
public class GeminiResponse {

    @Schema(
        description = "The AI-generated response text",
        example = "Quantum computing is like traditional" +
            " computing but uses quantum bits or 'qubits'..."
    )
    private String responseText;

    @Schema(
        description = "ID of the conversation. Use this in subsequent requests" +
            " to continue the same conversation.", example = "42"
    )
    private Long conversationId;

    @Schema(
        description = "List of previous conversation exchanges when retrieving a conversation history"
    )
    private List<Conversation> conversations;
}
