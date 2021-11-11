package com.example.dndcontroller.repos;

import com.example.dndcontroller.models.Armor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ArmorRepo extends CrudRepository<Armor, Integer> {

    Iterable<Armor> findAllByCategory(String category);
    Iterable<Armor> findAllByArmorClass(String armorClass);
    Optional<Armor> findByName(String name);
}
