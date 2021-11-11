package com.example.dndcontroller.controllers;

import com.example.dndcontroller.models.Spell;
import com.example.dndcontroller.repos.services.SpellService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/spell")
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class SpellController {

    private SpellService spellService;

    public SpellController(SpellService spellService) {
        this.spellService = spellService;
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Spell>> findAllSpells(){
        return ResponseEntity.ok(spellService.findAll());
    }

    @GetMapping("/{name}")
    public Iterable<Spell> findSpellName(@PathVariable String name) {
        return spellService.findByName(name);
    }

    @GetMapping("/school")
    public Iterable<Spell> findSpellSchool(@RequestParam String school){
        return spellService.findAllBySchool(school);
    }

    @GetMapping("/level")
    public Iterable<Spell> findSpellLevel(@RequestParam Integer level){
        return spellService.findAllByLevel(level);
    }

    @PostMapping("/")
    public ResponseEntity<Spell> addSpell(@RequestBody Spell spell){
        return new ResponseEntity<>(
                spellService.saveSpell(spell),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Spell> updateSpell(@RequestBody Spell spell){
        return new ResponseEntity<>(
                spellService.saveSpell(spell),
                HttpStatus.ACCEPTED
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Spell> patchSpell(@RequestBody Map<String, Object> updates, @PathVariable Integer id){
        return new ResponseEntity<>(
                spellService.patchSpell(updates, id),
                HttpStatus.ACCEPTED
        );
    }

    @DeleteMapping("/{id}")
    public void deleteSpell(@PathVariable Integer id){
        spellService.deleteSpell(id);
    }

    @DeleteMapping("/")
    public void deleteSpell(@RequestBody Spell spell){
        spellService.deleteSpell(spell);
    }

}
