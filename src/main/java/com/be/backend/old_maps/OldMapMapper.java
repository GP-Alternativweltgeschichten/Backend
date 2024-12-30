package com.be.backend.old_maps;

public class OldMapMapper {
    public static OldMapDTO toDTO(OldMap entity) {
        return new OldMapDTO(
                entity.getId(),
                entity.getMap(),
                entity.getDateOfMap(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public static OldMap toEntity(OldMapDTO dto) {
        return new OldMap(
                dto.getId(),
                dto.getMap(),
                dto.getDateOfMap(),
                dto.getCreatedAt(),
                dto.getUpdatedAt()
        );
    }
}
