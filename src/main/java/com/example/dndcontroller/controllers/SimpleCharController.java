package com.example.dndcontroller.controllers;

import com.example.dndcontroller.models.SimpleChar;
import com.example.dndcontroller.repos.services.SimpleCharService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/mob")
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class SimpleCharController {
    SimpleCharService simpleCharService;

    public SimpleCharController(SimpleCharService simpleCharService) {
        this.simpleCharService = simpleCharService;
    }

    @GetMapping("/{name}")
    public Iterable<SimpleChar> findByName(@PathVariable String name){
        return simpleCharService.findByName(name);
    }

    @GetMapping("/race")
    public Iterable<SimpleChar> findByRace(@RequestParam String race){
        return simpleCharService.findAllByRace(race);
    }

    @GetMapping("/chal")
    public Iterable<SimpleChar> findByChallenge(@RequestParam Double challenge){
        return simpleCharService.findAllByChallenge(challenge);
    }

    @GetMapping("/align")
    public Iterable<SimpleChar> findByAlignment(@RequestParam String alignment){
        return simpleCharService.findAllByAlignment(alignment);
    }

    @GetMapping("/")
    public Iterable<SimpleChar> findAll(){
        return simpleCharService.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<SimpleChar> saveSimpleChar(@RequestBody SimpleChar simpleChar){
        return new ResponseEntity<>(simpleCharService.saveSimpleChar(simpleChar),
                                HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<SimpleChar> updateSimpleChar(@RequestBody SimpleChar simpleChar){
        return new ResponseEntity<>(simpleCharService.updateSimpleChar(simpleChar),
                                    HttpStatus.ACCEPTED);
    }

    @PatchMapping ("/{id}")
    public ResponseEntity<SimpleChar> patchSimpleCHar(@RequestBody Map<String, Object> update, @PathVariable Integer id){
        return new ResponseEntity<>(simpleCharService.patchSimpleChar(update, id),
                                    HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/")
    public void deleteSimpleChar(@RequestBody SimpleChar simpleChar){
        simpleCharService.deleteSimpleChar(simpleChar);
    }

    @DeleteMapping("/{id}")
    public void deleteSimpleChar(@PathVariable Integer id){
        simpleCharService.deleteSimpleChar(id);
    }
}
