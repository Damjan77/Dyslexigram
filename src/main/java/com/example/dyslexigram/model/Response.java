package com.example.dyslexigram.model;

import javax.persistence.*;

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
