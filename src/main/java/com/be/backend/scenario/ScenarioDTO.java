package com.be.backend.scenario;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Value
public class ScenarioDTO implements Comparable<ScenarioDTO> {
    Integer id;
    String name;
    byte[] image;
    String description;
    boolean editable;
    boolean visible;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public ScenarioDTO(
            final Scenario entity
    ) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.image = entity.getImage();
        this.description = entity.getDescription();
        this.editable = entity.isEditable();
        this.visible = entity.isVisible();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
    }

    @Override
    public int compareTo(ScenarioDTO o) {
        return this.id.compareTo(o.id);
    }
}
