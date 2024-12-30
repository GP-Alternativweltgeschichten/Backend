package com.be.backend.old_maps;

import com.be.backend.maps.Map;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "OldMaps")
public class OldMap {
    @Id
    @Column(name = "id")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mapid", referencedColumnName = "id")
    @NotNull
    private Map map;

    @Column(name = "DateOfMap")
    @NotNull
    private String dateOfMap;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public OldMap(
            Integer id,
            Map map,
            String dateOfMap,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.map = map;
        this.dateOfMap = dateOfMap;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
