package com.example.dndcontroller.controllers;

import com.example.dndcontroller.models.Encounter;
import com.example.dndcontroller.repos.services.EncounterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/encounter")
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class EncounterController {

    private EncounterService encounterService;

    public EncounterController(EncounterService encounterService) {
        this.encounterService = encounterService;
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Encounter>> getAllEncounters(){
        return ResponseEntity.ok(encounterService.findAll());
    }

    @GetMapping("/id")
    public Encounter getById(@RequestParam Integer id){
        return encounterService.findById(id);
    }

    @GetMapping("/title")
    public Encounter getOneTitle(@RequestParam String title){
        return encounterService.findOneTitle(title);
    }

    @GetMapping("/{title}")
    public Iterable<Encounter> getByTitle(@PathVariable String title){
        return encounterService.findByTitle(title);
    }

    @PostMapping("/")
    public ResponseEntity<Encounter> addEncounter(@RequestBody Encounter encounter){
        return new ResponseEntity<>(
                encounterService.saveEncounter(encounter),
                HttpStatus.CREATED
        );
    }


    @PutMapping("/")
    public ResponseEntity<Encounter> updateEncounter(@RequestBody Encounter encounter){
        return new ResponseEntity<>(
                encounterService.updateEncounter(encounter),
                HttpStatus.ACCEPTED
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> partialUpdateCharacter(@RequestBody Map<String, Object> updates, @PathVariable Integer id){
        return new ResponseEntity<>(encounterService.patchEncounter(updates, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/")
    public void deleteEncounter(@RequestBody Encounter encounter){
        encounterService.deleteEncounter(encounter);
    }

    @DeleteMapping("/{id}")
    public void deleteEncounterId(@PathVariable Integer id){
        encounterService.deleteEncounter(id);
    }
}
