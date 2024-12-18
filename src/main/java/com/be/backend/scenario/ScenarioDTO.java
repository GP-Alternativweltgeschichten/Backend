package com.be.backend.scenario;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Value
public class ScenarioDTO implements Comparable<ScenarioDTO> {
    Integer id;
    String name;
    String description;
    Integer mapid;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public ScenarioDTO(
            final Scenario entity
    ) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.mapid = entity.getMapid();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
    }

    @Override
    public int compareTo(ScenarioDTO o) {
        return this.id.compareTo(o.id);
    }
}
