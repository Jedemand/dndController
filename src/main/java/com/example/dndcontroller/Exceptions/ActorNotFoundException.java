package com.example.dndcontroller.Exceptions;

public class ActorNotFoundException extends RuntimeException{

    public ActorNotFoundException(String name){
        super("Could not find character " + name);
    }
}
