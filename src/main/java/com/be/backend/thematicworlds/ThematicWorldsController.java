package com.be.backend.thematicworlds;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/thematicworlds")
@RequiredArgsConstructor
@Validated
public class ThematicWorldsController {
    private final ThematicWorldsService thematicWorldsService;

    @GetMapping("")
    public ResponseEntity<List<ThematicWorld>> getAllThematicWorlds() {
        return ResponseEntity.ok(thematicWorldsService.getAllThematicWorlds());
    }
}
