package com.example.dndcontroller.controllers;


import com.example.dndcontroller.models.Armor;
import com.example.dndcontroller.repos.services.ArmorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/armor")
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class ArmorController {

    ArmorService armorService;

    public ArmorController(ArmorService armorService) {
        this.armorService = armorService;
    }

    @GetMapping("/")
    public Iterable<Armor> findAllArmor(){
        return armorService.findAll();
    }

    @GetMapping("/{name}")
    public Iterable<Armor> findArmorByName(@PathVariable String name){
        return armorService.findByName(name);
    }

    @GetMapping("/type")
    public Iterable<Armor> findArmorByCat(@RequestParam String category){
        return armorService.findAllByCategory(category);
    }

    @GetMapping("/ac")
    public Iterable<Armor> findArmorByClass(@RequestParam String armorClass){
        return armorService.findAllByArmorClass(armorClass);
    }

    @PostMapping("/")
    public ResponseEntity<Armor> saveArmor(@RequestBody Armor armor){
        return new ResponseEntity<>(armorService.saveArmor(armor),
                HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Armor> updateArmor(@RequestBody Armor armor){
        return new ResponseEntity<>(armorService.updateArmor(armor),
                                    HttpStatus.ACCEPTED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Armor> patchArmor(Map<String, Object> updates, @PathVariable Integer id){
        return new ResponseEntity<>(armorService.patchArmor(updates, id),
                                    HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/")
    public void deleteArmor(Armor armor){
        armorService.deleteArmor(armor);
    }

    @DeleteMapping("/{id}")
    public void deleteArmor(@PathVariable Integer id){
        armorService.deleteArmor(id);
    }


}
