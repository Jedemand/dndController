package com.example.dndcontroller.repos;

import com.example.dndcontroller.models.Weapon;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WeaponRepo extends CrudRepository<Weapon, Integer> {

    Optional<Weapon> findAllByDmgType(Integer integer);
    Optional<Weapon> findByNameOrId(String name, Integer id);
    Iterable<Weapon> findByRarity(String rarity);
}
