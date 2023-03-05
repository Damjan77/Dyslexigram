package com.example.dyslexigram.model.exceptions;

public class InvalidQuestionIdException extends RuntimeException{
    public InvalidQuestionIdException() {
        super("Invalid Question ID!");
    }
}
