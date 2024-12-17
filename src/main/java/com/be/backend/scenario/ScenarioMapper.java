package com.be.backend.scenario;

public class ScenarioMapper {
    public static ScenarioDTO toDTO(Scenario entity) {
        return new ScenarioDTO(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getImage(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public static Scenario toEntity(ScenarioDTO dto) {
        return new Scenario(
                dto.getId(),
                dto.getName(),
                dto.getDescription(),
                dto.getImage(),
                dto.getCreatedAt(),
                dto.getUpdatedAt()
        );
    }
}
