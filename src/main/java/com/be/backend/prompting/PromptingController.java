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
        return ResponseEntity.ok(promptingService.getImageFromTextAndImageAndMaskAndRealism(request.prompt, request.image, request.mask, request.realism));
    }
}
