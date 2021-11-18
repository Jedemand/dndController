package com.example.dndcontroller.repos;

import com.example.dndcontroller.models.Item;
import org.springframework.data.repository.CrudRepository;


import java.util.Optional;


public interface ItemRepo extends CrudRepository<Item, Integer> {

    Iterable<Item> findAllByNameContains(String name);
    Iterable<Item> findAllByRarity(String rarity);
    Optional<Item> findById(Integer id);
}
