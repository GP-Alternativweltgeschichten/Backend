package com.be.backend.aiChat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AiChatDTO {
    String text;
    String image;
    String mask;
    Integer conversationId;
}

