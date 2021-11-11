package com.example.dndcontroller.repos.services.Impl;

import com.example.dndcontroller.Exceptions.ActorNotFoundException;
import com.example.dndcontroller.Exceptions.FieldNotFoundException;
import com.example.dndcontroller.models.ComplexChar;
import com.example.dndcontroller.repos.ComplexCharRepo;
import com.example.dndcontroller.repos.services.ComplexCharService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;


@Service
public class ComplexCharServiceImpl implements ComplexCharService {

    ComplexCharRepo complexCharRepo;


    public ComplexCharServiceImpl(ComplexCharRepo complexCharRepo) {
        this.complexCharRepo = complexCharRepo;
    }

    @Override
    public Iterable<ComplexChar> findByName(String name) {
        return complexCharRepo.findByNameIsLike(name);
    }

    @Override
    public ComplexChar findById(Integer id) {
        return complexCharRepo.findById(id)
                .orElseThrow(() -> new ActorNotFoundException(String.valueOf(id)));
    }

    @Override
    public Iterable<ComplexChar> findAllByChallenge(Double challenge) {
        return complexCharRepo.findAllByChallenge(challenge);
    }

    @Override
    public Iterable<ComplexChar> findAll() {
        return complexCharRepo.findAll();
    }

    @Override
    public ComplexChar saveComplexChar(ComplexChar complexChar) {
        return complexCharRepo.save(complexChar);
    }

    @Override
    public ComplexChar updateComplexChar(ComplexChar complexChar) {
        return complexCharRepo.save(complexChar);
    }

    @Override
    public ComplexChar patchComplexChar(Map<String, Object> updates, Integer id) {
        //find character by id
        ComplexChar patchedActor = complexCharRepo.findById(id)
                .orElseThrow(() -> new ActorNotFoundException(String.valueOf(id)));

        //iterate over Map of fields
        updates.forEach((k, o) -> {
            try{
                //get class and super fields
                Field[] classFields = patchedActor.getClass().getDeclaredFields();
                Field[] superFields = patchedActor.getClass().getSuperclass().getDeclaredFields();

                //combo!
                List<Field> combinedFields = new ArrayList<>(Arrays.asList(classFields));
                combinedFields.addAll(Arrays.asList(superFields));

                //check each item
                for (Field combinedField : combinedFields) {
                    //check to see if the field = k
                    if (combinedField.getName().equals(k)) {
                        combinedField.setAccessible(true);
                        combinedField.set(patchedActor, o);
                    }
                }
            }catch (IllegalAccessException | FieldNotFoundException ex){
                throw new FieldNotFoundException(k);
            }
        });
        return complexCharRepo.save(patchedActor);
    }

    @Override
    public void deleteComplexChar(ComplexChar complexChar) {
        complexCharRepo.delete(complexChar);
    }

    @Override
    public void deleteComplexChar(Integer id) {
        complexCharRepo.deleteById(id);
    }
}
