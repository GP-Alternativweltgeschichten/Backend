package com.be.backend.old_maps;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OldMapRepo extends JpaRepository<OldMap, Integer> {
}
