package com.be.backend.aiChat;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/aiChat")
@RequiredArgsConstructor
@Validated
public class AiChatController {
    private final AiChatService aiChatService;

    @PostMapping(value = "/text",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AiChatResponseDTO> getTextFromTextForChat(@RequestBody AiChatDTO request) {
        String answer = aiChatService.getTextForChat(request.getText(), request.getConversationId());
        AiChatResponseDTO out = new AiChatResponseDTO(answer,request.getConversationId());
        return ResponseEntity.ok(aiChatService.getTextForChat(request.text, request.conversationId));
    }

    @PostMapping(value = "/image",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getImageFromTextAndImageAndMask(@RequestBody AiChatDTO request ) {
        return ResponseEntity.ok(aiChatService.getTextFromImageForChat(request.image, request.mask, request.conversationId));
    }


}
