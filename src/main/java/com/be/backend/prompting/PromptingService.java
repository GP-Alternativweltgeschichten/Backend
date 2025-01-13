package com.be.backend.prompting;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class PromptingService {
    final String uri = "http://127.0.0.1:8000";
    RestTemplate restTemplate = new RestTemplate();

    public byte[] getImageFromText(String text) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(text, headers);

        ResponseEntity<byte[]> response = restTemplate.postForEntity(uri + "/text/", request, byte[].class);
        return response.getBody();
    }
}
