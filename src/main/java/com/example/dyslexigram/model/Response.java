package com.example.dyslexigram.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Response {

    @Id
    @GeneratedValue
    Long id;
    String text;


    public Response() {
    }

    public Response(String text) {
        this.text = text;
    }
}
