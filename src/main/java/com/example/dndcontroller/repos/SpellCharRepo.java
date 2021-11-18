package com.example.dndcontroller.repos;

import com.example.dndcontroller.models.SpellChar;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SpellCharRepo extends CrudRepository<SpellChar, Integer> {

    Iterable<SpellChar> findAllByNameContains(String name);
    Iterable<SpellChar> findAllByRace(String race);
    Iterable<SpellChar> findAllByChallenge(Double challenge);
    Iterable<SpellChar> findAllByAlignmentContains(String alignment);
    Optional<SpellChar> findByActorId(Integer id);


}
