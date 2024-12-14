package com.be.backend.scenario;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScenarioService {
    private final ScenarioRepo scenarioRepo;

    public List<ScenarioDTO> getAllScenarios() {
        return scenarioRepo.findAll();
    }

    public ScenarioDTO getScenarioById(Integer id) {
        Optional<ScenarioDTO> optionalScenario = scenarioRepo.findById(id);
        if (optionalScenario.isPresent()) {
            return optionalScenario.get();
        }
        log.info("Scenario with id {} not found", id);
        return null;
    }

    public ScenarioDTO saveScenario(ScenarioDTO scenario) {
        scenario.setCreatedAt(LocalDateTime.now());
        scenario.setUpdatedAt(LocalDateTime.now());
        ScenarioDTO savedScenario = scenarioRepo.save(scenario);

        log.info("Scenario with id {} saved", savedScenario.getId());
        return savedScenario;
    }

    public ScenarioDTO updateScenario(ScenarioDTO scenario) {
        Optional<ScenarioDTO> existingScenario = scenarioRepo.findById(scenario.getId());
        scenario.setCreatedAt(existingScenario.get().getCreatedAt());
        scenario.setUpdatedAt(LocalDateTime.now());

        ScenarioDTO updatedScenario = scenarioRepo.save(scenario);

        log.info("Scenario with id {} updated", updatedScenario.getId());
        return updatedScenario;
    }

    public void deleteScenarioById(Integer id) {
        scenarioRepo.deleteById(id);
        log.info("Scenario with id {} deleted", id);
    }
}
