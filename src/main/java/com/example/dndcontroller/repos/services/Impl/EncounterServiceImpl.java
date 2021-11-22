package com.example.dndcontroller.repos.services.Impl;


import com.example.dndcontroller.Exceptions.FieldNotFoundException;
import com.example.dndcontroller.Exceptions.ItemNotFoundException;
import com.example.dndcontroller.models.Encounter;
import com.example.dndcontroller.repos.EncounterRepo;
import com.example.dndcontroller.repos.services.EncounterService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class EncounterServiceImpl implements EncounterService {

    EncounterRepo encounterRepo;

    public EncounterServiceImpl(EncounterRepo encounterRepo) {
        this.encounterRepo = encounterRepo;
    }

    @Override
    public Iterable<Encounter> findByTitle(String title) {
        return encounterRepo.findByTitleContains(title);
    }

    @Override
    public Iterable<Encounter> findAll() {
        return encounterRepo.findAll();
    }

    @Override
    public Encounter findById(Integer id) {
        return encounterRepo.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(String.valueOf(id)));
    }

    @Override
    public Encounter findOneTitle(String title) {
        return encounterRepo.findByTitle(title)
                .orElseThrow(() -> new ItemNotFoundException(title));
    }

    @Override
    public Encounter saveEncounter(Encounter encounter) {
        return encounterRepo.save(encounter);
    }

    @Override
    public Encounter updateEncounter(Encounter encounter) {
        return encounterRepo.save(encounter);
    }

    @Override
    public Encounter patchEncounter(Map<String, Object> updates, Integer id) {
        Encounter patchedEncounter = encounterRepo.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(String.valueOf(id)));

        //iterate over Map of fields
        updates.forEach((k, o) -> {
            try{
                //get class and super fields
                Field[] classFields = patchedEncounter.getClass().getDeclaredFields();
                Field[] superFields = patchedEncounter.getClass().getSuperclass().getDeclaredFields();

                //combo!
                List<Field> combinedFields = new ArrayList<>(Arrays.asList(classFields));
                combinedFields.addAll(Arrays.asList(superFields));

                //check each item
                for (Field combinedField : combinedFields) {
                    //check to see if the field = k
                    if (combinedField.getName().equals(k)) {
                        combinedField.setAccessible(true);
                        combinedField.set(patchedEncounter, o);
                    }
                }
            }catch (IllegalAccessException | FieldNotFoundException ex){
                throw new FieldNotFoundException(k);
            }
        });
        return encounterRepo.save(patchedEncounter);
    }

    @Override
    public void deleteEncounter(Encounter encounter) {
        encounterRepo.delete(encounter);
    }

    @Override
    public void deleteEncounter(Integer id) {
        encounterRepo.deleteById(id);
    }
}
