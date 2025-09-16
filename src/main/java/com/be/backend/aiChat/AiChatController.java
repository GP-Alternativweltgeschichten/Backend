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

    @PostMapping("/text")
    public ResponseEntity<String> getTextFromTextForChat(@RequestBody AiChatDTO request) {
        return ResponseEntity.ok(aiChatService.getTextForChat(request.text, request.conversationId));
    }

    @PostMapping("/image")
    public ResponseEntity<String> getImageFromTextAndImageAndMask(@RequestBody AiChatDTO request ) {
        return ResponseEntity.ok(aiChatService.getTextFromImageForChat(request.image, request.mask, request.conversationId));
    }


}
