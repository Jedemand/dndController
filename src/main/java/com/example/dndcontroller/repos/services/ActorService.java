package com.example.dndcontroller.repos.services;

import com.example.dndcontroller.models.Actor;

import java.util.Map;
import java.util.Optional;

public interface ActorService {

    Actor findByName(String name);
    Iterable<Actor> findAllByChallenge(Integer challenge);

    Iterable<Actor> findAll();
    Actor saveActor(Actor actor);
    Actor updateActor(Actor actor);
    Actor patchActor(Map<String, Object> updates, Integer id);
    void deleteActor(Actor actor);
    void deleteActor(Integer id);
}
