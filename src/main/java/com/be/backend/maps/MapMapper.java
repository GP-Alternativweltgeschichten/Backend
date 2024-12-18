package com.be.backend.maps;

public class MapMapper {
    public static MapDTO toDTO(Map entity) {
        return new MapDTO(
                entity.getId(),
                entity.getName(),
                entity.getImage(),
                entity.isVisible(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public static Map toEntity(MapDTO dto) {
        return new Map(
                dto.getId(),
                dto.getName(),
                dto.getImage(),
                dto.isVisible(),
                dto.getCreatedAt(),
                dto.getUpdatedAt()
        );
    }
}
