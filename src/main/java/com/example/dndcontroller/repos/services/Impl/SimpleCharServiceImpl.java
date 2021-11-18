package com.example.dndcontroller.repos.services.Impl;

import com.example.dndcontroller.Exceptions.ActorNotFoundException;
import com.example.dndcontroller.Exceptions.FieldNotFoundException;
import com.example.dndcontroller.models.SimpleChar;
import com.example.dndcontroller.repos.SimpleCharRepo;
import com.example.dndcontroller.repos.services.SimpleCharService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Map;

@Service
public class SimpleCharServiceImpl implements SimpleCharService {

    SimpleCharRepo simpleCharRepo;

    public SimpleCharServiceImpl(SimpleCharRepo simpleCharRepo) {
        this.simpleCharRepo = simpleCharRepo;
    }

    @Override
    public Iterable<SimpleChar> findByName(String name) {
        return simpleCharRepo.findAllByNameContains(name);
    }

    @Override
    public Iterable<SimpleChar> findAllByRace(String race) {
        return simpleCharRepo.findAllByRace(race);
    }

    @Override
    public Iterable<SimpleChar> findAllByChallenge(Double challenge) {
        return simpleCharRepo.findAllByChallenge(challenge);
    }

    @Override
    public Iterable<SimpleChar> findAllByAlignment(String alignment) {
        return simpleCharRepo.findAllByAlignmentContains(alignment);
    }

    @Override
    public Iterable<SimpleChar> findAll() {
        return simpleCharRepo.findAll();
    }

    @Override
    public SimpleChar findById(Integer id) {
        return simpleCharRepo.findByActorId(id)
                .orElseThrow(() -> new ActorNotFoundException(String.valueOf(id)));
    }

    @Override
    public SimpleChar saveSimpleChar(SimpleChar simplechar) {
        return simpleCharRepo.save(simplechar);
    }

    @Override
    public SimpleChar updateSimpleChar(SimpleChar simplechar) {
        return simpleCharRepo.save(simplechar);
    }

    @Override
    public SimpleChar patchSimpleChar(Map<String, Object> updates, Integer id) {
        SimpleChar patchSimpChar = simpleCharRepo.findById(id)
                .orElseThrow(() -> new ActorNotFoundException(String.valueOf(id)));

        updates.forEach((k, o) -> {
            try{
                Field fieldName = patchSimpChar.getClass().getSuperclass().getDeclaredField(k);
                fieldName.setAccessible(true);
                fieldName.set(patchSimpChar, o);
            }catch (NoSuchFieldException | IllegalAccessException e){
                throw new FieldNotFoundException(k);
            }
        });

        return simpleCharRepo.save(patchSimpChar);
    }

    @Override
    public void deleteSimpleChar(SimpleChar simplechar) {
        simpleCharRepo.delete(simplechar);
    }

    @Override
    public void deleteSimpleChar(Integer id) {
        simpleCharRepo.deleteById(id);
    }
}
