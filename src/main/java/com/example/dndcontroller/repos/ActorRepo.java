package com.example.dndcontroller.repos;

import com.example.dndcontroller.models.Actor;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ActorRepo extends CrudRepository<Actor, Integer> {


    Iterable<Actor> findAllByChallenge(Integer challenge);
    Optional<Actor> findByName(String name);

}
