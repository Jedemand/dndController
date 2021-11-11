package com.example.dndcontroller.controllers;

import com.example.dndcontroller.models.SpellChar;
import com.example.dndcontroller.repos.services.SpellCharService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/spellcaster")
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class SpellCharController {
    SpellCharService spellCharService;

    public SpellCharController(SpellCharService spellCharService) {
        this.spellCharService = spellCharService;
    }

    @GetMapping("/{name}")
    public Iterable<SpellChar> findByName(@PathVariable String name){
        return spellCharService.findByName(name);
    }

    @GetMapping("/race")
    public Iterable<SpellChar> findByRace(@RequestParam String race){
        return spellCharService.findAllByRace(race);
    }

    @GetMapping("/chal")
    public Iterable<SpellChar> findByChallenge(@RequestParam Double challenge){
        return spellCharService.findAllByChallenge(challenge);
    }

    @GetMapping("/align")
    public Iterable<SpellChar> findByAlignment(@RequestParam String alignment){
        return spellCharService.findAllByAlignment(alignment);
    }

    @GetMapping("/")
    public Iterable<SpellChar> findAll(){
        return spellCharService.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<SpellChar> saveSpellChar(@RequestBody SpellChar spellChar){
        return new ResponseEntity<>(spellCharService.saveSpellChar(spellChar),
                                HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<SpellChar> updateSpellChar(@RequestBody SpellChar spellChar){
        return new ResponseEntity<>(spellCharService.updateSpellChar(spellChar),
                                    HttpStatus.ACCEPTED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SpellChar> patchSpellChar(@RequestBody Map<String, Object> update, @PathVariable Integer id){
        return new ResponseEntity<>(spellCharService.patchSpellChar(update, id),
                                    HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/")
    public void deleteSpellChar(@RequestBody SpellChar spellChar){
        spellCharService.deleteSpellChar(spellChar);
    }

    @DeleteMapping("/{id}")
    public void deleteSpellChar(@PathVariable Integer id){
        spellCharService.deleteSpellChar(id);
    }
}
