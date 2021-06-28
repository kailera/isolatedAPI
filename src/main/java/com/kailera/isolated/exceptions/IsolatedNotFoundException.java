package com.kailera.isolated.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IsolatedNotFoundException extends Exception {

    public IsolatedNotFoundException(Long id){
        super(String.format("Isolado com id %s não foi encontrado", id));
    }
}
