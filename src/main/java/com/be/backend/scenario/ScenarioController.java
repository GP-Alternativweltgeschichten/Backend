package com.be.backend.scenario;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scenarios")
@RequiredArgsConstructor
@Validated
public class ScenarioController {
    private final ScenarioService scenarioService;

    @GetMapping("")
    public ResponseEntity<List<ScenarioDTO>> getAllScenarios() {
        return ResponseEntity.ok(scenarioService.getAllScenarios().stream().map(ScenarioMapper::toDTO).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScenarioDTO> getScenarioById(@PathVariable Integer id) {
        return ResponseEntity.ok(ScenarioMapper.toDTO(scenarioService.getScenarioById(id)));
    }

    @GetMapping("/{id}/map")
    public ResponseEntity<byte[]> getScenarioMapById(@PathVariable Integer id) {
        Scenario scenario = scenarioService.getScenarioById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "scenario; filename=\"" + scenario.getName() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(scenario.getImage());
    }

    @PostMapping("")
    public ResponseEntity<ScenarioDTO> saveScenario(@RequestBody Scenario scenario) {
        return ResponseEntity.ok(ScenarioMapper.toDTO(scenarioService.saveScenario(scenario)));
    }

    @PutMapping("")
    public ResponseEntity<ScenarioDTO> updateScenario(@RequestBody Scenario scenario) {
        return ResponseEntity.ok(ScenarioMapper.toDTO(scenarioService.updateScenario(scenario)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScenarioById(@PathVariable Integer id) {
        scenarioService.deleteScenarioById(id);
        return ResponseEntity.ok().build();
    }
}
