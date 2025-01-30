package com.be.backend.thematicworlds;

import com.be.backend.oldmaps.OldMap;
import com.be.backend.oldmaps.OldMapRepo;
import com.be.backend.scenario.Scenario;
import com.be.backend.scenario.ScenarioDTO;
import com.be.backend.scenario.ScenarioRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ThematicWorldsService {
    private final ScenarioRepo scenarioRepo;
    private final OldMapRepo oldMapRepo;

    public List<ThematicWorld> getAllThematicWorlds() {
        List<ThematicWorld> thematicWorlds = new ArrayList<>();

        List<Scenario> scenarios = scenarioRepo.findAllVisible();
        for (Scenario scenario : scenarios) {
           thematicWorlds.add(new ThematicWorld(scenario.getId(), scenario.getName(), scenario.getDescription(), scenario.getImage(), true, scenario.isEditable()));
        }

        List<OldMap> oldMaps = oldMapRepo.findAllVisible();
        for (OldMap oldMap : oldMaps) {
            thematicWorlds.add(new ThematicWorld(oldMap.getId(), oldMap.getName(), oldMap.getDateOfMap(), oldMap.getImage(), false, oldMap.isEditable()));
        }

        //thematicWorlds.sort(Comparator.comparing(ThematicWorld::getName));
        return thematicWorlds;
    }
}
