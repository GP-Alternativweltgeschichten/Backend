package com.be.backend.oldmaps;

import com.be.backend.maps.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import java.util.Date;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Value
public class OldMapDTO implements Comparable<OldMapDTO> {
    Integer id;
    Map map;
    String DateOfMap;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public OldMapDTO(
            final OldMap entity
    ) {
        this.id = entity.getId();
        this.map = entity.getMap();
        this.DateOfMap = entity.getDateOfMap();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
    }

    @Override
    public int compareTo(OldMapDTO o) {
        return this.id.compareTo(o.id);
    }
}
