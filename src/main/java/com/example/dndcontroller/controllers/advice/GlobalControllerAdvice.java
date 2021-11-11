package com.example.dndcontroller.controllers.advice;

import com.example.dndcontroller.Exceptions.*;
import com.example.dndcontroller.models.Spell;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalControllerAdvice {


    @ExceptionHandler(ActorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String productNotFoundHandler(ActorNotFoundException pEx){
        return pEx.getLocalizedMessage();
    }


    @ExceptionHandler(FieldNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    String fieldNotFoundHandler(FieldNotFoundException fEx){
        return fEx.getLocalizedMessage();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String generalExceptionHandler(Exception ex){
        System.out.println(ex.getLocalizedMessage());
        return "General Server Error";
    }

    @ExceptionHandler(UnAuthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    String unAuthorizedExceptionHandler(Exception uEx){
        return uEx.getLocalizedMessage();
    }

    @ExceptionHandler(SpellNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String spellNotfoundHandler(SpellNotFoundException hEx){return hEx.getLocalizedMessage();}

    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String itemNotFoundHandler(ItemNotFoundException iEx){return iEx.getLocalizedMessage();}
}