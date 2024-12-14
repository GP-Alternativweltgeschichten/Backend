package com.be.backend.old_maps;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/old_maps")
@RequiredArgsConstructor
@Validated
public class OldMapController {
    private final OldMapService oldMapService;

    @GetMapping("/")
    public ResponseEntity<List<OldMapDTO>> getAllOldMaps() {
        return ResponseEntity.ok(oldMapService.getAllOldMaps());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OldMapDTO> getOldMapById(@PathVariable Integer id) {
        return ResponseEntity.ok(oldMapService.getOldMapById(id));
    }

    @PostMapping("/")
    public ResponseEntity<OldMapDTO> saveOldMap(@RequestBody OldMapDTO oldMap) {
        return ResponseEntity.ok(oldMapService.saveOldMap(oldMap));
    }

    @PutMapping("/")
    public ResponseEntity<OldMapDTO> updateOldMap(@RequestBody OldMapDTO oldMap) {
        return ResponseEntity.ok(oldMapService.updateOldMap(oldMap));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOldMapById(@PathVariable Integer id) {
        oldMapService.deleteOldMapById(id);
        return ResponseEntity.ok().build();
    }
}
