package com.example.dndcontroller.Exceptions;

public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException(String name){
        super("Could not find item " + name);
    }
}
