package com.example.dndcontroller.Exceptions;

public class FieldNotFoundException extends RuntimeException{

    public FieldNotFoundException(String fieldName) {

        super("Object does not contain field: " + fieldName);
    }
}
