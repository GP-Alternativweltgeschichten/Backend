package com.be.backend.prompting;

import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/prompting")
@RequiredArgsConstructor
@Validated
public class PromptingController {
    private final PromptingService promptingService;

    @PostMapping("/text")
    public ResponseEntity<byte[]> getImageFromText(@RequestBody String text) throws IOException, JSONException, URISyntaxException {

        return ResponseEntity.ok(promptingService.getImageFromText(text));
    }






}
