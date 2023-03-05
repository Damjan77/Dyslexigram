package com.example.dyslexigram.model.exceptions;

public class InvalidResponseIdException extends RuntimeException{
    public InvalidResponseIdException() {
        super("Invalid Response ID!");
    }
}
