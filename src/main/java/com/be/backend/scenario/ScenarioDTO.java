package com.be.backend.scenario;

import com.be.backend.maps.Map;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Value
public class ScenarioDTO implements Comparable<ScenarioDTO> {
    Integer id;
    String name;
    String description;
    Map map;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public ScenarioDTO(
            final Scenario entity
    ) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.map = entity.getMap();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
    }

    @Override
    public int compareTo(ScenarioDTO o) {
        return this.id.compareTo(o.id);
    }
}
