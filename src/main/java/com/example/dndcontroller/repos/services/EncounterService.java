package com.example.dndcontroller.repos.services;

import com.example.dndcontroller.models.Encounter;
import com.example.dndcontroller.models.SimpleChar;

import java.util.Map;

public interface EncounterService {


    Iterable<Encounter> findByTitle(String title);
    Encounter findById(Integer id);
    Iterable<Encounter> findAll();
    Encounter saveEncounter(Encounter encounter);
    Encounter updateEncounter(Encounter encounter);
    Encounter patchEncounter(Map<String, Object> updates, Integer id);
    void deleteEncounter(Encounter encounter);
    void deleteEncounter(Integer id);
}
