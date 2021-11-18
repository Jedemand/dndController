package com.example.dndcontroller.repos.services;

import com.example.dndcontroller.models.Armor;
import com.example.dndcontroller.models.Weapon;

import java.util.Map;

public interface ArmorService {

    Iterable<Armor> findAllByCategory(String category);
    Iterable<Armor> findAllByArmorClass(String armorClass);
    Iterable<Armor> findAll();
    Iterable<Armor> findByName(String name);
    Armor findById(Integer id);
    Armor saveArmor(Armor armor);
    Armor updateArmor(Armor armor);
    Armor patchArmor(Map<String, Object> updates, Integer id);
    void deleteArmor(Armor armor);
    void deleteArmor(Integer id);
}
