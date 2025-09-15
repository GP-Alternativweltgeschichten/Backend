package com.be.backend.aiChat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AiChatResponseDTO {
    private String responseText;
    private String conversationId;
}
