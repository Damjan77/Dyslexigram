package com.example.dyslexigram.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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
