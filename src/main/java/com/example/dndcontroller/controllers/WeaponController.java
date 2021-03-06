package com.example.dndcontroller.controllers;

import com.example.dndcontroller.models.Weapon;
import com.example.dndcontroller.repos.services.WeaponService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/weapon")
@Slf4j
public class WeaponController {

    WeaponService weaponService;

    public WeaponController(WeaponService weaponService) {
        this.weaponService = weaponService;
    }

    @GetMapping("/")
    public Iterable<Weapon> findAllWeapons(){
        return weaponService.findAll();
    }

    @GetMapping("/find")
    public Weapon findByNameOrId(@RequestParam String name, Integer id){
        return weaponService.findByNameOrId(name, id);
    }

    @GetMapping("/{rarity}")
    public Iterable<Weapon> findByRarity(@PathVariable String rarity){
        return weaponService.findByRarity(rarity);
    }

    @PostMapping("/")
    public ResponseEntity<Weapon> saveWeapon(@RequestBody Weapon weapon){
        return new ResponseEntity<>(weaponService.saveWeapon(weapon),
                HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Weapon> updateWeapon(@RequestBody Weapon weapon){
        return new ResponseEntity<>(weaponService.updateWeapon(weapon),
                HttpStatus.ACCEPTED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> partialUpdateWeapon(@RequestBody Map<String, Object> updates, @PathVariable Integer id){
        return new ResponseEntity<>(weaponService.patchWeapon(updates, id),
                HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/")
    public void deleteWeapon(@RequestBody Weapon weapon){
        weaponService.deleteWeapon(weapon);
    }

    @DeleteMapping("/{id}")
    public void deleteWeapon(@PathVariable Integer id){
        weaponService.deleteWeapon(id);
    }




}
