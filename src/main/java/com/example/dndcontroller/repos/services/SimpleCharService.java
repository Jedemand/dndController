package com.example.dndcontroller.repos.services;

import com.example.dndcontroller.models.SimpleChar;

import java.util.Map;

public interface SimpleCharService {

    Iterable<SimpleChar> findByName(String name);
    Iterable<SimpleChar> findAllByRace(String race);
    Iterable<SimpleChar> findAllByChallenge(Double challenge);
    Iterable<SimpleChar> findAllByAlignment(String alignment);

    Iterable<SimpleChar> findAll();
    SimpleChar saveSimpleChar(SimpleChar simplechar);
    SimpleChar updateSimpleChar(SimpleChar simplechar);
    SimpleChar patchSimpleChar(Map<String, Object> updates, Integer id);
    void deleteSimpleChar(SimpleChar simplechar);
    void deleteSimpleChar(Integer id);
}
