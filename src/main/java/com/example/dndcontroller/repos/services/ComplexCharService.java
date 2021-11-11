package com.example.dndcontroller.repos.services;

import com.example.dndcontroller.models.ComplexChar;

import java.util.Map;
import java.util.Optional;

public interface ComplexCharService {

    Iterable<ComplexChar> findByName(String name);
    Iterable<ComplexChar> findAllByChallenge(Double challenge);

    Iterable<ComplexChar> findAll();
    ComplexChar findById(Integer id);
    ComplexChar saveComplexChar(ComplexChar complexChar);
    ComplexChar updateComplexChar(ComplexChar complexChar);
    ComplexChar patchComplexChar(Map<String, Object> updates, Integer id);
    void deleteComplexChar(ComplexChar complexChar);
    void deleteComplexChar(Integer id);
}
