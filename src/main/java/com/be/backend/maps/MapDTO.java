package com.be.backend.maps;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Value
public class MapDTO implements Comparable<MapDTO> {
    Integer id;
    String name;
    byte[] image;
    boolean visible;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public MapDTO(
            final Map entity
    ) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.image = entity.getImage();
        this.visible = entity.isVisible();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
    }

    @Override
    public int compareTo(MapDTO o) {
        return this.id.compareTo(o.id);
    }
}
