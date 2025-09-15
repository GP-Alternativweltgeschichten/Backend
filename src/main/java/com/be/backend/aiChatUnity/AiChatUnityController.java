package com.be.backend.aiChatUnity;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aiChatUnity")
@RequiredArgsConstructor
@Validated
public class AiChatUnityController {

    private final AiChatUnityService aiChatUnityService;

    @PostMapping("/text")
    public ResponseEntity<byte[]> getImageFromText(@RequestBody String text) {
        return ResponseEntity.ok(aiChatUnityService.getImageFromText(text));
    }

    @PostMapping("/inpainting")
    public ResponseEntity<byte[]> getImageFromTextAndImageAndMask(@RequestBody AiChatUnityDTO request) {
        return ResponseEntity.ok(aiChatUnityService.getImageFromInpaintInformation(
                request.getPrompt(),
                request.getImage(),
                request.getMask(),
                request.getModel(),
                request.getGuidanceScale()
        ));
    }
    @GetMapping("/aiModel")
    public ResponseEntity<Number> getAiModel() {
        return ResponseEntity.ok(aiChatUnityService.getAiModel());
    }

    @PostMapping("/aiModel")
    public ResponseEntity<Void> setAiModel(@RequestBody Number aiModel) {
        aiChatUnityService.setAiModel(aiModel);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/unity")
    public ResponseEntity<String> receiveJsonAndImage(@RequestBody AiChatUnityDTO dto) {
        String response = aiChatUnityService.forwardUnitySelection(dto);
        return ResponseEntity.ok(response);
    }
}
