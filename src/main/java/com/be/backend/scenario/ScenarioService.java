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

    public List<Scenario> getAllScenarios() {
        return scenarioRepo.findAll();
    }

    public Scenario getScenarioById(Integer id) {
        Optional<Scenario> optionalScenario = scenarioRepo.findById(id);
        if (optionalScenario.isPresent()) {
            return optionalScenario.get();
        }
        log.info("Scenario with id {} not found", id);
        return null;
    }

    public Scenario saveScenario(Scenario scenario) {
        scenario.setCreatedAt(LocalDateTime.now());
        scenario.setUpdatedAt(LocalDateTime.now());
        Scenario savedScenario = scenarioRepo.save(scenario);

        log.info("Scenario with id {} saved", savedScenario.getId());
        return savedScenario;
    }

    public Scenario updateScenario(Scenario scenario) {
        Optional<Scenario> existingScenario = scenarioRepo.findById(scenario.getId());
        scenario.setCreatedAt(existingScenario.get().getCreatedAt());
        scenario.setUpdatedAt(LocalDateTime.now());

        Scenario updatedScenario = scenarioRepo.save(scenario);

        log.info("Scenario with id {} updated", updatedScenario.getId());
        return updatedScenario;
    }

    public void deleteScenarioById(Integer id) {
        scenarioRepo.deleteById(id);
        log.info("Scenario with id {} deleted", id);
    }
}
