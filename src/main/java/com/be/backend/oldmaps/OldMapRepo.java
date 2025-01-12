package com.be.backend.oldmaps;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OldMapRepo extends JpaRepository<OldMap, Integer> {

    @Query("SELECT om FROM OldMap om WHERE om.visible = true")
    List<OldMap> findAllVisible();

}
