//GeminiController.java
package com.josesanchez.geminiwrapper.controller;

import static com.josesanchez.geminiwrapper.controller.http.CustomHeaders.ERROR_MESSAGE_HEADER;

import com.josesanchez.geminiwrapper.controller.annotations.BadRequestResponse;
import com.josesanchez.geminiwrapper.controller.annotations.InternalServerErrorResponse;
import com.josesanchez.geminiwrapper.controller.annotations.NotFoundResponse;
import com.josesanchez.geminiwrapper.exception.BadRequestException;
import com.josesanchez.geminiwrapper.exception.ElementNotFoundException;
import com.josesanchez.geminiwrapper.model.GeminiRequest;
import com.josesanchez.geminiwrapper.model.GeminiResponse;
import com.josesanchez.geminiwrapper.service.GeminiService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gemini-ai-wrapper/v1")
public class GeminiController {

    private final GeminiService geminiService;

    @Autowired
    public GeminiController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @PostMapping("/chat")
    @Operation(summary = "Interact with Gemini AI",
        description = "Sends a prompt to Gemini AI and returns the response. When starting a new conversation, " +
        "do NOT include a conversationId in the request. The API will generate a new conversationId for you " +
        "in the response. Only include a conversationId when continuing an existing conversation.")
    @ApiResponse(responseCode = "200", description = "Successful operation",
        content = @Content(schema = @Schema(implementation = GeminiResponse.class)))
    @BadRequestResponse
    @InternalServerErrorResponse
    public ResponseEntity<?> chatWithGemini(@RequestBody GeminiRequest request) {
        try {
            GeminiResponse response = geminiService.getResponse(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .header(ERROR_MESSAGE_HEADER, e.getMessage()).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header(ERROR_MESSAGE_HEADER, e.getMessage()).build();
        }
    }

    @GetMapping("/conversation/{conversationId}")
    @Operation(summary = "Get Conversation History", description = "Retrieves a specific conversation by ID.")
    @ApiResponse(responseCode = "200", description = "Successful operation",
        content = @Content(schema = @Schema(implementation = GeminiResponse.class)))
    @BadRequestResponse
    @NotFoundResponse
    @InternalServerErrorResponse
    public ResponseEntity<?> getConversation(@PathVariable("conversationId") Long conversationId) {
        try {
            if (conversationId == null || conversationId <= 0) {
                throw new BadRequestException("Invalid conversation ID: " + conversationId);
            }
            GeminiResponse response = geminiService.getConversation(conversationId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .header(ERROR_MESSAGE_HEADER, e.getMessage()).build();
        } catch (ElementNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .header(ERROR_MESSAGE_HEADER, e.getMessage()).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header(ERROR_MESSAGE_HEADER, e.getMessage()).build();
        }
    }

    @GetMapping("/conversation")
    @Operation(summary = "Get all Conversations", description = "Retrieves all conversations.")
    @ApiResponse(responseCode = "200", description = "Successful operation",
        content = @Content(schema = @Schema(implementation = GeminiResponse.class)))
    @InternalServerErrorResponse
    public ResponseEntity<?> getAllConversation() {
        try {
            GeminiResponse response = geminiService.getAllConversation();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header(ERROR_MESSAGE_HEADER, e.getMessage()).build();
        }
    }
}
