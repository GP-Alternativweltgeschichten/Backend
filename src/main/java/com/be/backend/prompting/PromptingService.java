package com.be.backend.prompting;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class PromptingService {
    final String uri = "http://127.0.0.1:8000";
    RestTemplate restTemplate = new RestTemplate();

//    0 = OlpeAI
//    1 = ChatGPT
    public Number aiModel = 0;

    public byte[] getImageFromText(String text) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(text, headers);

        ResponseEntity<byte[]> response = restTemplate.postForEntity(uri + "/text/", request, byte[].class);
        return response.getBody();
    }

    public byte[] getImageFromTextAndImageAndMaskAndRealism(String text, String image, String mask, int realism) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String body = "{\"prompt\":\"" + text + "\",\"image\":\"" + image + "\",\"mask\":\"" + mask + "\",\"realism\":\"" + realism + "\"}";

        HttpEntity<String> request = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<byte[]> response = restTemplate.exchange(
                uri + "/inpainting/", HttpMethod.POST, request, byte[].class);
        return response.getBody();
    }

    public Number getAiModel() {
        return aiModel;
    }

    public void setAiModel(Number aiModel) {
        this.aiModel = aiModel;
        System.out.println("AI Model set to " + aiModel);
    }
}
