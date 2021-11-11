package com.example.dndcontroller.repos.services.Impl;

import com.example.dndcontroller.Exceptions.FieldNotFoundException;
import com.example.dndcontroller.Exceptions.ItemNotFoundException;
import com.example.dndcontroller.models.Armor;
import com.example.dndcontroller.repos.ArmorRepo;
import com.example.dndcontroller.repos.services.ArmorService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class ArmorServiceImpl implements ArmorService {

    ArmorRepo armorRepo;

    public ArmorServiceImpl(ArmorRepo armorRepo) {
        this.armorRepo = armorRepo;
    }

    @Override
    public Iterable<Armor> findAllByCategory(String category) {
        return armorRepo.findAllByCategory(category);
    }

    @Override
    public Iterable<Armor> findAllByArmorClass(String armorClass) {
        return armorRepo.findAllByArmorClass(armorClass);
    }

    @Override
    public Iterable<Armor> findAll() {
        return armorRepo.findAll();
    }

    @Override
    public Armor findByName(String name) {
        return armorRepo.findByName(name)
                .orElseThrow(() -> new ItemNotFoundException(name));
    }

    @Override
    public Armor saveArmor(Armor armor) {
        return armorRepo.save(armor);
    }

    @Override
    public Armor updateArmor(Armor armor) {
        return armorRepo.save(armor);
    }

    @Override
    public Armor patchArmor(Map<String, Object> updates, Integer id) {
        //pull the object to be saved
        Armor patchedArmor = armorRepo.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(String.valueOf(id)));

        updates.forEach((k, o) -> {
            try{
                //get class and super fields
                Field[] classFields = patchedArmor.getClass().getDeclaredFields();
                Field[] superFields = patchedArmor.getClass().getSuperclass().getDeclaredFields();

                //combo!
                List<Field> combinedFields = new ArrayList<>(Arrays.asList(classFields));
                combinedFields.addAll(Arrays.asList(superFields));

                //check each item
                for (Field combinedField : combinedFields) {
                    //check to see if the field = k
                    if (combinedField.getName().equals(k)) {
                        combinedField.setAccessible(true);
                        combinedField.set(patchedArmor, o);
                    }
                }
            }catch (IllegalAccessException | FieldNotFoundException ex){
                throw new FieldNotFoundException(k);
            }
        });

        return armorRepo.save(patchedArmor);
    }

    @Override
    public void deleteArmor(Armor armor) {
        armorRepo.delete(armor);
    }

    @Override
    public void deleteArmor(Integer id) {
        armorRepo.deleteById(id);
    }
}
