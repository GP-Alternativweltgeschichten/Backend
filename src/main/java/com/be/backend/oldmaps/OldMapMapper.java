package com.be.backend.oldmaps;

public class OldMapMapper {
    public static OldMapDTO toDTO(OldMap entity) {
        return new OldMapDTO(
                entity.getId(),
                entity.getName(),
                entity.getImage(),
                entity.getDateOfMap(),
                entity.isEditable(),
                entity.isVisible(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public static OldMap toEntity(OldMapDTO dto) {
        return new OldMap(
                dto.getId(),
                dto.getName(),
                dto.getImage(),
                dto.getDateOfMap(),
                dto.isEditable(),
                dto.isVisible(),
                dto.getCreatedAt(),
                dto.getUpdatedAt()
        );
    }
}
