package com.example.dndcontroller.repos;

import com.example.dndcontroller.models.Item;
import org.springframework.data.repository.CrudRepository;


import java.util.Optional;


public interface ItemRepo extends CrudRepository<Item, Integer> {

    Optional<Item> findByNameOrId(String name, Integer id);
    Iterable<Item> findAllByRarity(String rarity);
}
