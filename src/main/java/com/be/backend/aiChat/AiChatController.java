package com.be.backend.aiChat;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Base64;
@RestController
@RequestMapping("/aiChat")
@RequiredArgsConstructor
@Validated
public class AiChatController {

    private final AiChatService aiChatService;

    @PostMapping("/text")
    public ResponseEntity<byte[]> getImageFromText(@RequestBody String text) {
        return ResponseEntity.ok(aiChatService.getImageFromText(text));
    }

    @PostMapping("/inpainting")
    public ResponseEntity<byte[]> getImageFromTextAndImageAndMask(@RequestBody AiChatDTO request) {
        return ResponseEntity.ok(aiChatService.getImageFromInpaintInformation(
                request.getPrompt(),
                request.getImage(),
                request.getMask(),
                request.getModel(),
                request.getGuidanceScale()
        ));
    }
    @GetMapping("/aiModel")
    public ResponseEntity<Number> getAiModel() {
        return ResponseEntity.ok(aiChatService.getAiModel());
    }

    @PostMapping("/aiModel")
    public ResponseEntity<Void> setAiModel(@RequestBody Number aiModel) {
        aiChatService.setAiModel(aiModel);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/unity")
    public ResponseEntity<String> receiveJsonAndImage(@RequestBody AiChatDTO dto) {
        String response = aiChatService.forwardUnitySelection(dto);
        return ResponseEntity.ok(response);
    }
}
