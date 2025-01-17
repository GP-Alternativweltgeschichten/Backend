package com.be.backend.scenario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScenarioRepo extends JpaRepository<Scenario, Integer> {

    @Query("SELECT s FROM Scenario s WHERE s.visible = true")
    List<Scenario> findAllVisible();

}
