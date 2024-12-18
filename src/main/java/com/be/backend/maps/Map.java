package com.be.backend.maps;

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
@Table(name = "Maps")
public class Map {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    @NotNull
    private String name;

    @Column(name = "image")
    @JdbcTypeCode(Types.VARBINARY)
    @Lob
    private byte[] image;

    @Column(name = "visible",  columnDefinition = "boolean default true")
    private boolean visible;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "map")
    private Map map;

    public Map(
            Integer id,
            String name,
            byte[] image,
            boolean visible,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.visible = visible;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
