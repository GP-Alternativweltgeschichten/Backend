package com.be.backend.oldmaps;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "Old_Map")
public class OldMap {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", nullable = false)
    @NotNull
    private String name;

    @Column(name = "image")
    @JdbcTypeCode(Types.VARBINARY)
    @Lob
    private byte[] image;

    @Column(name = "date_of_map")
    private String dateOfMap;

    @Column(name = "editable",  columnDefinition = "boolean default true")
    private boolean editable;

    @Column(name = "visible",  columnDefinition = "boolean default true")
    private boolean visible;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public OldMap(
            Integer id,
            String name,
            byte[] image,
            String dateOfMap,
            boolean editable,
            boolean visible,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.dateOfMap = dateOfMap;
        this.editable = editable;
        this.visible = visible;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
