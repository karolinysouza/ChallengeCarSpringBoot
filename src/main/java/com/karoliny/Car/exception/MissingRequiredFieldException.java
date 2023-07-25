package com.karoliny.Car.exception;

public class MissingRequiredFieldException extends CarException {
    public MissingRequiredFieldException(String message) {
        super(message);
    }
}
