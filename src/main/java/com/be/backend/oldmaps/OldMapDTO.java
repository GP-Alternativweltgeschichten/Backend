package com.be.backend.oldmaps;

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
    byte[] image;
    String dateOfMap;
    boolean editable;
    boolean visible;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public OldMapDTO(
            final OldMap entity
    ) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.image = entity.getImage();
        this.dateOfMap = entity.getDateOfMap();
        this.editable = entity.isEditable();
        this.visible = entity.isVisible();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
    }

    @Override
    public int compareTo(OldMapDTO o) {
        return this.id.compareTo(o.id);
    }
}
