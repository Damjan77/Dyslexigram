package com.example.dyslexigram.model.exceptions;

public class InvalidUserIdException extends RuntimeException{
    public InvalidUserIdException() {
        super("Invalid User ID!");
    }
}
