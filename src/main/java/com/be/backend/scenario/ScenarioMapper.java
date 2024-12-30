package com.be.backend.scenario;

public class ScenarioMapper {
    public static ScenarioDTO toDTO(Scenario entity) {
        return new ScenarioDTO(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getMap(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public static Scenario toEntity(ScenarioDTO dto) {
        return new Scenario(
                dto.getId(),
                dto.getName(),
                dto.getMap(),
                dto.getDescription(),
                dto.getCreatedAt(),
                dto.getUpdatedAt()
        );
    }
}
