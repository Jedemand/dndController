package com.example.dndcontroller.repos.services.Impl;

import com.example.dndcontroller.Exceptions.ActorNotFoundException;
import com.example.dndcontroller.Exceptions.FieldNotFoundException;
import com.example.dndcontroller.models.Actor;
import com.example.dndcontroller.repos.ActorRepo;
import com.example.dndcontroller.repos.services.ActorService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Map;


@Service
public class ActorServiceImpl implements ActorService {

    ActorRepo actorRepo;

    public ActorServiceImpl(ActorRepo actorRepo) {
        this.actorRepo = actorRepo;
    }

    @Override
    public Actor findByName(String name) {
        return actorRepo.findByName(name).
                orElseThrow(() -> new ActorNotFoundException(name));
    }

    @Override
    public Iterable<Actor> findAllByChallenge(Integer challenge) {
        return actorRepo.findAllByChallenge(challenge);
    }

    @Override
    public Iterable<Actor> findAll() {
        return actorRepo.findAll();
    }

        @Override
    public Actor saveActor(Actor actor) {
        return actorRepo.save(actor);
    }

    @Override
    public Actor updateActor(Actor actor) {
        return actorRepo.save(actor);
    }

    @Override
    public Actor patchActor(Map<String, Object> updates, Integer id) {
        //find character by id
        Actor patchedActor = actorRepo.findById(id)
                .orElseThrow(() -> new ActorNotFoundException(String.valueOf(id)));

        //iterate over Map of fields
        updates.forEach((k, o) -> {
            System.out.println(k + ":" + o);

            try{
                //use reflection to get accessor
                Field nameField = patchedActor.getClass().getDeclaredField(k);
                nameField.setAccessible(true);
                nameField.set(patchedActor, o);
            }catch (NoSuchFieldException | IllegalAccessException e){
                //handle problems
                throw new FieldNotFoundException(k);
            }
        });
        return actorRepo.save(patchedActor);
    }

    @Override
    public void deleteActor(Actor actor) {
        actorRepo.delete(actor);
    }

    @Override
    public void deleteActor(Integer id) {
        actorRepo.deleteById(id);
    }
}
