package com.be.backend.aiChatUnity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AiChatUnityDTO {
    private String prompt;
    private String image;                 // Base64-kodiertes Bild von Unity
    private String mask;                  // Optional: Base64-kodierte Maske
    private int buildingCount;            // Anzahl aller Gebäude
    private List<String> categories;      // Kategorien aller Assets
    private List<String> uniqueBuildings; // Unique Namen besonderer Gebäude
    private int model;                    // Modell-Auswahl (0 = OlpeAI, 1 = ChatGPT)
    private int guidanceScale;            // Guidance-Scale Wert
}
