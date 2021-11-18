package com.example.dndcontroller.repos;

import com.example.dndcontroller.models.Encounter;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EncounterRepo extends CrudRepository<Encounter, Integer> {

    Iterable<Encounter> findByTitleContains(String title);
    Optional<Encounter> findById(Integer id);
}
