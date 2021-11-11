package com.example.dndcontroller.repos.services;

import com.example.dndcontroller.models.SpellChar;

import java.util.Map;

public interface SpellCharService {

    Iterable<SpellChar> findByName(String name);
    Iterable<SpellChar> findAllByRace(String race);
    Iterable<SpellChar> findAllByChallenge(Double challenge);
    Iterable<SpellChar> findAllByAlignment(String alignment);

    Iterable<SpellChar> findAll();
    SpellChar saveSpellChar(SpellChar spellChar);
    SpellChar updateSpellChar(SpellChar spellChar);
    SpellChar patchSpellChar(Map<String, Object> updates, Integer id);
    void deleteSpellChar(SpellChar spellChar);
    void deleteSpellChar(Integer id);
}
