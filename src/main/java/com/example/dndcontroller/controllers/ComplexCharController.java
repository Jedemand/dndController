package com.example.dndcontroller.controllers;

import com.example.dndcontroller.Exceptions.ActorNotFoundException;
import com.example.dndcontroller.models.ComplexChar;
import com.example.dndcontroller.repos.services.ComplexCharService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/character")
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class ComplexCharController {


    private ComplexCharService complexCharService;

    public ComplexCharController(ComplexCharService complexCharService) {
        this.complexCharService = complexCharService;
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<ComplexChar>> getAllCharacters(){
        return ResponseEntity.ok(complexCharService.findAll());
    }

    @GetMapping("/id")
    public ComplexChar findById(@RequestParam Integer id){
        return complexCharService.findById(id);
    }


    @GetMapping("/{name}")
    public Iterable<ComplexChar> findByName(@PathVariable String name) throws  ActorNotFoundException {
        return complexCharService.findByName(name);
    }

    @GetMapping("/challenge")
    public Iterable<ComplexChar> findByChallenge(@RequestParam Double challenge){
        return complexCharService.findAllByChallenge(challenge);
    }


    @PostMapping("/")
    public ResponseEntity<ComplexChar> addCharacter(@RequestBody ComplexChar actor){
        return new ResponseEntity<>(
                complexCharService.saveComplexChar(actor),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<ComplexChar> updateCharacter(@RequestBody ComplexChar actor){
        return new ResponseEntity<>(complexCharService.updateComplexChar(actor), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> partialUpdateCharacter(@RequestBody Map<String, Object> updates, @PathVariable Integer id){
        return new ResponseEntity<>(complexCharService.patchComplexChar(updates, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/")
    public void deleteCharacter(@RequestBody ComplexChar actor){
        complexCharService.deleteComplexChar(actor);
    }

    @DeleteMapping("/{id}")
    public void deleteCharacterId(@PathVariable Integer id){
        complexCharService.deleteComplexChar(id);
    }





}
