package com.example.dndcontroller.repos;

import com.example.dndcontroller.models.Encounter;
import org.springframework.data.repository.CrudRepository;

public interface EncounterRepo extends CrudRepository<Encounter, Integer> {

    Iterable<Encounter> findByTitleIsLike(String title);
}
