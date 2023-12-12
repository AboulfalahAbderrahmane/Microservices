package com.formationSpring.accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.lang.String;
@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class RessourceNotFoundException extends RuntimeException{
    public RessourceNotFoundException(String message,String fieldName,String fieldValue){
        super(message+"not found whith the given input data"+fieldName+":"+fieldValue);
    }
}
