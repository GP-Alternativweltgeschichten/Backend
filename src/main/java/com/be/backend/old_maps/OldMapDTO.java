package com.be.backend.old_maps;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Value
public class OldMapDTO implements Comparable<OldMapDTO> {
    Integer id;
    String name;
    String description;
    byte[] image;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public OldMapDTO(
            final OldMap entity
    ) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.image = entity.getImage();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
    }

    @Override
    public int compareTo(OldMapDTO o) {
        return this.id.compareTo(o.id);
    }
}
