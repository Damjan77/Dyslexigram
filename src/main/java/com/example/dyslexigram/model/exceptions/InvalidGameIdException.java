package com.example.dyslexigram.model.exceptions;

public class InvalidGameIdException extends RuntimeException{
    public InvalidGameIdException() {
        super("Invalid Game ID!");
    }
}
