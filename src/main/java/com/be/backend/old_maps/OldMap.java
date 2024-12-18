package com.be.backend.old_maps;

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
    private Integer mapid;

    @Column(name = "DateOfMap")
    @NotNull
    private String dateOfMap;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public OldMap(
            Integer id,
            Integer mapid,
            String dateOfMap,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.mapid = mapid;
        this.dateOfMap = dateOfMap;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
