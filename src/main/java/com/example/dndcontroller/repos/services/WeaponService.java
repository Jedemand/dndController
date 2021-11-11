package com.example.dndcontroller.repos.services;

import com.example.dndcontroller.models.Weapon;

import java.util.Map;

public interface WeaponService {

    Weapon findByNameOrId(String name, Integer id);
    Iterable<Weapon> findByRarity(String rarity);
    Iterable<Weapon> findAll();
    Weapon saveWeapon(Weapon weapon);
    Weapon updateWeapon(Weapon weapon);
    Weapon patchWeapon(Map<String, Object> updates, Integer id);
    void deleteWeapon(Weapon weapon);
    void deleteWeapon(Integer weapon);
}
