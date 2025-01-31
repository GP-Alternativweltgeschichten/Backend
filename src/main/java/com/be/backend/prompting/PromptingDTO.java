package com.be.backend.prompting;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PromptingDTO {
    String prompt;
    String image;
    String mask;
}
