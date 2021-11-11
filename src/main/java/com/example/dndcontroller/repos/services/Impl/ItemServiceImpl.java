package com.example.dndcontroller.repos.services.Impl;

import com.example.dndcontroller.Exceptions.FieldNotFoundException;
import com.example.dndcontroller.Exceptions.ItemNotFoundException;
import com.example.dndcontroller.models.Item;
import com.example.dndcontroller.repos.ItemRepo;
import com.example.dndcontroller.repos.services.ItemService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    ItemRepo itemRepo;

    public ItemServiceImpl(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @Override
    public Item findByNameOrId(String name, Integer id) {
        return itemRepo.findByNameOrId(name, id)
                .orElseThrow(() -> new ItemNotFoundException((name == null ? String.valueOf(id) : name)));
    }

    @Override
    public Iterable<Item> findAll() {
        return itemRepo.findAll();
    }

    @Override
    public Iterable<Item> findByRarity(String rarity) {
        return itemRepo.findAllByRarity(rarity);
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepo.save(item);
    }

    @Override
    public Item updateItem(Item item) {
        return itemRepo.save(item);
    }

    @Override
    public Item patchItem(Map<String, Object> updates, Integer id) {
        //instance item to be patched
        Item patchedItem = itemRepo.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(String.valueOf(id)));

        //go through field
        updates.forEach((k, o) -> {
            try{
                Field fieldName = patchedItem.getClass().getSuperclass().getDeclaredField(k);
                fieldName.setAccessible(true);
                fieldName.set(patchedItem, o);
            }catch (NoSuchFieldException | IllegalAccessException e){
                throw new FieldNotFoundException(k);
            }
        });

        return itemRepo.save(patchedItem);
    }

    @Override
    public void deleteItem(Item item) {
        itemRepo.delete(item);
    }

    @Override
    public void deleteItem(Integer item) {
        itemRepo.deleteById(item);
    }
}
