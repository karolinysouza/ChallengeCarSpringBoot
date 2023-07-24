package com.karoliny.Car.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundExeption extends RuntimeException  {
    public PersonNotFoundExeption(String msg) {

        super(msg);
    }
}
