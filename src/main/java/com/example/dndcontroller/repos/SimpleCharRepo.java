package com.example.dndcontroller.repos;

import com.example.dndcontroller.models.SimpleChar;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SimpleCharRepo extends CrudRepository<SimpleChar, Integer> {

    Iterable<SimpleChar> findAllByNameContains(String name);
    Iterable<SimpleChar> findAllByRace(String race);
    Iterable<SimpleChar> findAllByChallenge(Double challenge);
    Iterable<SimpleChar> findAllByAlignmentContains(String alignment);

}
