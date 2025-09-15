package com.be.backend.aiChatUnity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class AiChatUnityService {

    private final String uri = "http://127.0.0.1:8000"; // Dein Python-Backend
    private final RestTemplate restTemplate = new RestTemplate();

    // 0 = OlpeAI
    // 1 = ChatGPT
    private Number aiModel = 0;

    public byte[] getImageFromText(String text) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String body = "{\"prompt\":\"" + text + "\"}";
        HttpEntity<String> request = new HttpEntity<>(body, headers);

        ResponseEntity<byte[]> response = restTemplate.postForEntity(
                uri + "/text/", request, byte[].class);
        return response.getBody();
    }

    public byte[] getImageFromInpaintInformation(
            String text,
            String imageBase64,
            String maskBase64,
            int model,
            int guidanceScale
    ) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Strings direkt weiterschicken (Python kann auch Base64 lesen)
        String body = String.format(
                "{\"prompt\":\"%s\",\"image\":\"%s\",\"mask\":\"%s\",\"model\":%d,\"guidance_scale\":%d}",
                text,
                imageBase64 != null ? imageBase64 : "",
                maskBase64 != null ? maskBase64 : "",
                model,
                guidanceScale
        );

        HttpEntity<String> request = new HttpEntity<>(body, headers);

        ResponseEntity<byte[]> response = restTemplate.exchange(
                uri + "/inpainting/", HttpMethod.POST, request, byte[].class);
        return response.getBody();
    }

    public String forwardUnitySelection(AiChatUnityDTO unityDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<AiChatUnityDTO> request = new HttpEntity<>(unityDTO, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(
                uri + "/generate", request, String.class);

        return response.getBody();
    }

    public Number getAiModel() {
        return aiModel;
    }

    public void setAiModel(Number aiModel) {
        this.aiModel = aiModel;
        log.info("AI Model set to {}", aiModel);
    }
}
