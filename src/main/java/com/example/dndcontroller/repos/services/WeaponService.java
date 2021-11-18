package com.example.dndcontroller.repos.services;

import com.example.dndcontroller.models.Weapon;

import java.util.Map;

public interface WeaponService {

    Iterable<Weapon> findByName(String name);
    Iterable<Weapon> findByRarity(String rarity);
    Iterable<Weapon> findAll();
    Weapon findById(Integer id);
    Weapon saveWeapon(Weapon weapon);
    Weapon updateWeapon(Weapon weapon);
    Weapon patchWeapon(Map<String, Object> updates, Integer id);
    void deleteWeapon(Weapon weapon);
    void deleteWeapon(Integer weapon);
}
