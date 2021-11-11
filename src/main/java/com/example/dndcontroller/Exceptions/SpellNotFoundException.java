package com.example.dndcontroller.Exceptions;

public class SpellNotFoundException extends RuntimeException{

    public SpellNotFoundException(String name){
        super("Could not find spell" + name);
    }
}
