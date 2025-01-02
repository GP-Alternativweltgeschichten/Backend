package com.be.backend.prompting;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PromptingService {

    public String getText(String text) {
        log.info("Text received: {}", text);
        return text;
    }

}
