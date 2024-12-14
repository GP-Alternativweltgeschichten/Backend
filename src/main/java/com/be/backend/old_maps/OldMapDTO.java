package com.be.backend.old_maps;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class OldMapDTO implements Comparable<OldMapDTO> {
    private Integer id;
    private String name;
    private String description;
    private byte[] image;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

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
