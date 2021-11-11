package com.example.dndcontroller.repos;

import com.example.dndcontroller.models.Weapon;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WeaponRepo extends CrudRepository<Weapon, Integer> {

    Iterable<Weapon> findAllByDmgType(Integer integer);
    Iterable<Weapon> findAllByNameContains(String name);
    Iterable<Weapon> findByRarity(String rarity);
}
