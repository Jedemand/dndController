package com.example.dndcontroller.Exceptions;


public class UnAuthorizedException extends RuntimeException{

    public UnAuthorizedException(String msg){
        super(msg);
    }
}
