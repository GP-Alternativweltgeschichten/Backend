package com.be.backend.oldmaps;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oldmaps")
@RequiredArgsConstructor
@Validated
public class OldMapController {
    private final OldMapService oldMapService;

    @GetMapping("")
    public ResponseEntity<List<OldMapDTO>> getAllOldMaps() {
        return ResponseEntity.ok(oldMapService.getAllOldMaps().stream().map(OldMapMapper::toDTO).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OldMapDTO> getOldMapById(@PathVariable Integer id) {
        return ResponseEntity.ok(OldMapMapper.toDTO(oldMapService.getOldMapById(id)));
    }

    @PostMapping("")
    public ResponseEntity<OldMapDTO> saveOldMap(@RequestBody OldMap oldMap) {
        return ResponseEntity.ok(OldMapMapper.toDTO(oldMapService.saveOldMap(oldMap)));
    }

    @PutMapping("")
    public ResponseEntity<OldMapDTO> updateOldMap(@RequestBody OldMap oldMap) {
        return ResponseEntity.ok(OldMapMapper.toDTO(oldMapService.updateOldMap(oldMap)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOldMapById(@PathVariable Integer id) {
        oldMapService.deleteOldMapById(id);
        return ResponseEntity.ok().build();
    }
}
