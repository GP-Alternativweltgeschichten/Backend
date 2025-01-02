package com.be.backend.maps;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MapService {
    private final MapRepo MapRepo;

    public List<Map> getAllMaps() {
        return MapRepo.findAll();
    }

    public Map getMapById(Integer id) {
        Optional<Map> optionalMap = MapRepo.findById(id);
        if (optionalMap.isPresent()) {
            return optionalMap.get();
        }
        log.info("Map with id {} not found", id);
        return null;
    }

    public Map saveMap(Map Map) {
        Map.setCreatedAt(LocalDateTime.now());
        Map.setUpdatedAt(LocalDateTime.now());
        Map savedMap = MapRepo.save(Map);

        log.info("Map with id {} saved", savedMap.getId());
        return savedMap;
    }

    public Map updateMap(Map Map) {
        Optional<Map> existingMap = MapRepo.findById(Map.getId());
        Map.setCreatedAt(existingMap.get().getCreatedAt());
        Map.setUpdatedAt(LocalDateTime.now());

        Map updatedMap = MapRepo.save(Map);

        log.info("Map with id {} updated", updatedMap.getId());
        return updatedMap;
    }

    public void deleteMapById(Integer id) {
        MapRepo.deleteById(id);
        log.info("Map with id {} deleted", id);
    }

}
