package com.be.backend.aiChat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AiChatDTO {

    // ===== Alte Felder (für Text & Inpainting) =====
    private String prompt;
    private String image;       // Base64 Screenshot oder Inpainting-Input
    private String mask;
    private int model;
    private int guidanceScale;

    // ===== Neue Felder (für Unity-Auswahl) =====
    private int count;                       // Anzahl aller Gebäude
    private List<AssetInfo> assets;          // Kategorien + Namen
    private List<String> uniqueBuildings;    // Besondere Gebäude
}
