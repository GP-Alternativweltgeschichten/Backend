package com.be.backend.old_maps;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OldMapService {
    private final OldMapRepo oldMapRepo;

    public List<OldMapDTO> getAllOldMaps() {
        return oldMapRepo.findAll();
    }

    public OldMapDTO getOldMapById(Integer id) {
        Optional<OldMapDTO> optionalOldMap = oldMapRepo.findById(id);
        if (optionalOldMap.isPresent()) {
            return optionalOldMap.get();
        }
        log.info("OldMap with id {} not found", id);
        return null;
    }

    public OldMapDTO saveOldMap(OldMapDTO oldMap) {
        oldMap.setCreatedAt(LocalDateTime.now());
        oldMap.setUpdatedAt(LocalDateTime.now());
        OldMapDTO savedOldMap = oldMapRepo.save(oldMap);

        log.info("OldMap with id {} saved", savedOldMap.getId());
        return savedOldMap;
    }

    public OldMapDTO updateOldMap(OldMapDTO oldMap) {
        Optional<OldMapDTO> existingOldMap = oldMapRepo.findById(oldMap.getId());
        oldMap.setCreatedAt(existingOldMap.get().getCreatedAt());
        oldMap.setUpdatedAt(LocalDateTime.now());

        OldMapDTO updatedOldMap = oldMapRepo.save(oldMap);

        log.info("OldMap with id {} updated", updatedOldMap.getId());
        return updatedOldMap;
    }

    public void deleteOldMapById(Integer id) {
        oldMapRepo.deleteById(id);
        log.info("OldMap with id {} deleted", id);
    }
}
