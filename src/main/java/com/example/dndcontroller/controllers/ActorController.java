package com.example.dndcontroller.controllers;

import com.example.dndcontroller.Exceptions.ActorNotFoundException;
import com.example.dndcontroller.models.Actor;
import com.example.dndcontroller.repos.ActorRepo;
import com.example.dndcontroller.repos.services.ActorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/actor")
@Slf4j
public class ActorController {


    private ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Actor>> getAllActors(){
        return ResponseEntity.ok(actorService.findAll());
    }


    @GetMapping("/{name}")
    public Actor findByName(@PathVariable String name) throws  ActorNotFoundException {
        return actorService.findByName(name);
    }

    @GetMapping("/challenge")
    public Iterable<Actor> findByChallenge(@RequestParam Integer challenge){
        return actorService.findAllByChallenge(challenge);
    }


    @PostMapping("/")
    public ResponseEntity<Actor> addActor(@RequestBody Actor actor){
        return new ResponseEntity<>(
                actorService.saveActor(actor),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Actor> updateActor(@RequestBody Actor actor){
        return new ResponseEntity<>(actorService.updateActor(actor), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> partialUpdateActor(@RequestBody Map<String, Object> updates, @PathVariable Integer id){
        return new ResponseEntity<>(actorService.patchActor(updates, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/")
    public void deleteActor(@RequestBody Actor actor){
        actorService.deleteActor(actor);
    }

    @DeleteMapping("/{id}")
    public void deleteActorId(@PathVariable Integer id){
        actorService.deleteActor(id);
    }





}
