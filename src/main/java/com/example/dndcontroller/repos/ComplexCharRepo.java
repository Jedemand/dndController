package com.example.dndcontroller.repos;

import com.example.dndcontroller.models.ComplexChar;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ComplexCharRepo extends CrudRepository<ComplexChar, Integer> {


    Iterable<ComplexChar> findAllByChallenge(Double challenge);
    Iterable<ComplexChar> findByNameIsLike(String name);
    Optional<ComplexChar> findByActorId(Integer id);

}
