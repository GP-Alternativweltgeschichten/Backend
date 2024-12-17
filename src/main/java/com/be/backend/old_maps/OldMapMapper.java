package com.be.backend.old_maps;

public class OldMapMapper {
    public static OldMapDTO toDTO(OldMap entity) {
        return new OldMapDTO(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getImage(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public static OldMap toEntity(OldMapDTO dto) {
        return new OldMap(
                dto.getId(),
                dto.getName(),
                dto.getDescription(),
                dto.getImage(),
                dto.getCreatedAt(),
                dto.getUpdatedAt()
        );
    }
}
