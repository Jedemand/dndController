package com.example.dndcontroller.controllers;

import com.example.dndcontroller.models.Item;
import com.example.dndcontroller.repos.services.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/item")
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {

    ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public Iterable<Item> findAll(){
        return itemService.findAll();
    }

    @GetMapping("/{rarity}")
    public Iterable<Item> findByRarity(@PathVariable String rarity){
        return itemService.findByRarity(rarity);
    }

    @GetMapping("/find")
    public Iterable<Item> findByName(@RequestParam String name){
        return itemService.findByName(name);
    }

    @PostMapping("/")
    public ResponseEntity<Item> saveItem(@RequestBody Item item){
        return ResponseEntity.ok(itemService.saveItem(item));
    }

    @PutMapping("/")
    public ResponseEntity<Item> updateItem(@RequestBody Item item){
        return new ResponseEntity<>(
                itemService.updateItem(item),
                HttpStatus.ACCEPTED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Item> patchItem(@RequestBody Map<String, Object> updates, @PathVariable Integer id){
        return ResponseEntity.ok(itemService.patchItem(updates, id));
    }

    @DeleteMapping("/")
    public void deleteItem(@RequestBody Item item){
        itemService.deleteItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteId(@PathVariable Integer id){
        itemService.deleteItem(id);
    }
}
