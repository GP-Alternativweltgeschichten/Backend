package com.be.backend.maps;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maps")
@RequiredArgsConstructor
@Validated
public class MapController {
    private final MapService MapService;

    @GetMapping("")
    public ResponseEntity<List<MapDTO>> getAllMaps() {
        return ResponseEntity.ok(MapService.getAllMaps().stream().map(MapMapper::toDTO).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MapDTO> getMapById(@PathVariable Integer id) {
        return ResponseEntity.ok(MapMapper.toDTO(MapService.getMapById(id)));
    }

    @PostMapping("")
    public ResponseEntity<MapDTO> saveMap(@RequestBody Map Map) {
        return ResponseEntity.ok(MapMapper.toDTO(MapService.saveMap(Map)));
    }

    @PutMapping("")
    public ResponseEntity<MapDTO> updateMap(@RequestBody Map Map) {
        return ResponseEntity.ok(MapMapper.toDTO(MapService.updateMap(Map)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMapById(@PathVariable Integer id) {
        MapService.deleteMapById(id);
        return ResponseEntity.ok().build();
    }

}
