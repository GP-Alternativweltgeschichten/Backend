package com.be.backend.oldmaps;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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

    @GetMapping("/{id}/map")
    public ResponseEntity<byte[]> getOldMapMapById(@PathVariable Integer id) {
        OldMap oldMap = oldMapService.getOldMapById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "oldmap; filename=\"" + oldMap.getName() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(oldMap.getImage());
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
