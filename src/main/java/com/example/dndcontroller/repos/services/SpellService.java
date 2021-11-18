package com.example.dndcontroller.repos.services;

import com.example.dndcontroller.models.Spell;

import java.util.Map;

public interface SpellService {

    Iterable<Spell> findAllBySchool(String school);
    Iterable<Spell> findAllByLevel(Integer level);
    Iterable<Spell> findByName(String name);

    Iterable<Spell> findAll();
    Spell findById(Integer id);
    Spell saveSpell(Spell spell);
    Spell updateSpell(Spell spell);
    Spell patchSpell(Map<String, Object> updates, Integer id);
    void deleteSpell(Spell spell);
    void deleteSpell(Integer id);
}
