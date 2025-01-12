package com.be.backend.thematicworlds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor
@Getter
@Value
public class ThematicWorld {
    Integer id;
    String name;
    String description;
    byte[] image;
    boolean editable;

    public ThematicWorld(
            final ThematicWorld entity
    ) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.image = entity.getImage();
        this.editable = entity.isEditable();
    }
}
