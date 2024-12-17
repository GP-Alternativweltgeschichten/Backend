package com.be.backend.scenario;

import lombok.RequiredArgsConstructor;
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

    @GetMapping("/")
    public ResponseEntity<List<ScenarioDTO>> getAllScenarios() {
        return ResponseEntity.ok(scenarioService.getAllScenarios().stream().map(ScenarioMapper::toDTO).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScenarioDTO> getScenarioById(@PathVariable Integer id) {
        return ResponseEntity.ok(ScenarioMapper.toDTO(scenarioService.getScenarioById(id)));
    }

    @PostMapping("/")
    public ResponseEntity<ScenarioDTO> saveScenario(@RequestBody Scenario scenario) {
        return ResponseEntity.ok(ScenarioMapper.toDTO(scenarioService.saveScenario(scenario)));
    }

    @PutMapping("/")
    public ResponseEntity<ScenarioDTO> updateScenario(@RequestBody Scenario scenario) {
        return ResponseEntity.ok(ScenarioMapper.toDTO(scenarioService.updateScenario(scenario)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScenarioById(@PathVariable Integer id) {
        scenarioService.deleteScenarioById(id);
        return ResponseEntity.ok().build();
    }
}
