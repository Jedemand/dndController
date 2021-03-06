package com.example.dndcontroller.repos.services;

import com.example.dndcontroller.models.Item;

import java.util.Map;

public interface ItemService {

    Item findByNameOrId(String name, Integer id);
    Iterable<Item> findByRarity(String rarity);
    Iterable<Item> findAll();
    Item saveItem(Item item);
    Item updateItem(Item item);
    Item patchItem(Map<String, Object> updates, Integer id);
    void deleteItem(Item item);
    void deleteItem(Integer item);
}
