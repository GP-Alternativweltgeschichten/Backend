package com.be.backend.prompting;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prompting")
@RequiredArgsConstructor
@Validated
public class PromptingController {
    private final PromptingService promptingService;

    @PostMapping("/text")
    public ResponseEntity<byte[]> getImageFromText(@RequestBody String text) {
        return ResponseEntity.ok(promptingService.getImageFromText(text));
    }

    @PostMapping("/inpainting")
    public ResponseEntity<byte[]> getImageFromTextAndImageAndMask(@RequestBody PromptingDTO request) {
        return ResponseEntity.ok(promptingService.getImageFromInpaintInformation(request.prompt, request.image, request.mask, request.model, request.guidanceScale));
    }

    @GetMapping("/aiModel")
    public ResponseEntity<Number> getAiModel() {
        return ResponseEntity.ok(promptingService.getAiModel());
    }

    @PostMapping("/aiModel")
    public ResponseEntity<Void> setAiModel(@RequestBody Number aiModel) {
        promptingService.setAiModel(aiModel);
        return ResponseEntity.ok().build();
    }
}
