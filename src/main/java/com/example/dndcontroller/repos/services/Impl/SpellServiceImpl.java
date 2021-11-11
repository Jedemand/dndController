package com.example.dndcontroller.repos.services.Impl;

import com.example.dndcontroller.Exceptions.FieldNotFoundException;
import com.example.dndcontroller.Exceptions.SpellNotFoundException;
import com.example.dndcontroller.models.Spell;
import com.example.dndcontroller.repos.SpellRepo;
import com.example.dndcontroller.repos.services.SpellService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Map;


@Service
public class SpellServiceImpl implements SpellService {

    SpellRepo spellRepo;

    public SpellServiceImpl(SpellRepo spellRepo) {
        this.spellRepo = spellRepo;
    }

    @Override
    public Iterable<Spell> findAllBySchool(String school) {
        return spellRepo.findAllBySchool(school);
    }

    @Override
    public Iterable<Spell> findAllByLevel(Integer level) {
        return spellRepo.findAllByLevel(level);
    }

    @Override
    public Iterable<Spell> findByName(String name) {
        return spellRepo.findBySpellNameContains(name);
    }

    @Override
    public Iterable<Spell> findAll() {
        return spellRepo.findAll();
    }

    @Override
    public Spell saveSpell(Spell spell) {
        return spellRepo.save(spell);
    }

    @Override
    public Spell updateSpell(Spell spell) {
        return spellRepo.save(spell);
    }

    @Override
    public Spell patchSpell(Map<String, Object> updates, Integer id) {
        //find spell by id
        Spell patchedSpell = spellRepo.findById(id)
                .orElseThrow(() -> new SpellNotFoundException(String.valueOf(id)));

        //iterate over fields
        updates.forEach((k, o) -> {
            System.out.println(k + ":" + o);

            try{
                Field fieldName = patchedSpell.getClass().getDeclaredField(k);
                fieldName.setAccessible(true);
                fieldName.set(patchedSpell, o);
            }catch (NoSuchFieldException | IllegalAccessException e){
                throw new FieldNotFoundException(k);
            }
        });

        return spellRepo.save(patchedSpell);
    }

    @Override
    public void deleteSpell(Spell spell) {
        spellRepo.delete(spell);
    }

    @Override
    public void deleteSpell(Integer id) {
        spellRepo.deleteById(id);
    }
}
