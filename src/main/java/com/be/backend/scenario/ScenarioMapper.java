package com.be.backend.scenario;

public class ScenarioMapper {
    public static ScenarioDTO toDTO(Scenario entity) {
        return new ScenarioDTO(
                entity.getId(),
                entity.getName(),
                entity.getImage(),
                entity.getDescription(),
                entity.isEditable(),
                entity.isVisible(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public static Scenario toEntity(ScenarioDTO dto) {
        return new Scenario(
                dto.getId(),
                dto.getName(),
                dto.getImage(),
                dto.getDescription(),
                dto.isEditable(),
                dto.isVisible(),
                dto.getCreatedAt(),
                dto.getUpdatedAt()
        );
    }
}
