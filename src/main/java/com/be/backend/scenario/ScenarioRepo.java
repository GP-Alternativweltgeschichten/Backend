package com.be.backend.scenario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenarioRepo extends JpaRepository<ScenarioDTO, Integer> {
}
