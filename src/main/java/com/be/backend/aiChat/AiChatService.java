package com.be.backend.aiChat;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class AiChatService {
    final String uri = "http://127.0.0.1:8000";
    RestTemplate restTemplate = new RestTemplate();



    public String getTextForChat(String text, Integer conversationId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String body = "{\"text\":\"" + text + "\",\"conversationId\":" + conversationId + "}";
        HttpEntity<String> request = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(uri + "/text", request, String.class);
        System.out.println(response.getBody() + " = getTextForChat output");
        return response.getBody();
    }

    public String getTextFromImageForChat(String image, String mask, Integer conversationId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String body = "{\"image\":\"" + image + "\",\"mask\":\"" + mask + "\",\"conversationId\":\"" + conversationId + "\"}";
        HttpEntity<String> request = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                uri + "/MarkedImage/", HttpMethod.POST, request, String.class);
        return response.getBody();
    }

}
