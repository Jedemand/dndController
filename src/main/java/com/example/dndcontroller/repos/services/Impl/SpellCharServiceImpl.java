package com.example.dndcontroller.repos.services.Impl;

import com.example.dndcontroller.Exceptions.ActorNotFoundException;
import com.example.dndcontroller.Exceptions.FieldNotFoundException;
import com.example.dndcontroller.models.SpellChar;
import com.example.dndcontroller.repos.SpellCharRepo;
import com.example.dndcontroller.repos.services.SpellCharService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Map;

@Service
public class SpellCharServiceImpl implements SpellCharService {

    SpellCharRepo spellCharRepo;

    public SpellCharServiceImpl(SpellCharRepo spellCharRepo) {
        this.spellCharRepo = spellCharRepo;
    }

    @Override
    public Iterable<SpellChar> findByName(String name) {
        return spellCharRepo.findAllByNameContains(name);
    }

    @Override
    public Iterable<SpellChar> findAllByRace(String race) {
        return spellCharRepo.findAllByRace(race);
    }

    @Override
    public Iterable<SpellChar> findAllByChallenge(Double challenge) {
        return spellCharRepo.findAllByChallenge(challenge);
    }

    @Override
    public Iterable<SpellChar> findAllByAlignment(String alignment) {
        return spellCharRepo.findAllByAlignmentContains(alignment);
    }

    @Override
    public Iterable<SpellChar> findAll() {
        return spellCharRepo.findAll();
    }

    @Override
    public SpellChar saveSpellChar(SpellChar spellChar) {
        return spellCharRepo.save(spellChar);
    }

    @Override
    public SpellChar updateSpellChar(SpellChar spellChar) {
        return spellCharRepo.save(spellChar);
    }

    @Override
    public SpellChar patchSpellChar(Map<String, Object> updates, Integer id) {
        SpellChar patchSimpChar = spellCharRepo.findById(id)
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

        return spellCharRepo.save(patchSimpChar);
    }

    @Override
    public void deleteSpellChar(SpellChar spellChar) {
        spellCharRepo.delete(spellChar);
    }

    @Override
    public void deleteSpellChar(Integer id) {
        spellCharRepo.deleteById(id);
    }
}
