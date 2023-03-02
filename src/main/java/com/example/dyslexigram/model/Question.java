package com.example.dyslexigram.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue
    Long id;
    String text;

    @OneToMany
    private List<Response> responses;
    @OneToOne
    private Response correct_answer;

    public Question() {
        responses = new ArrayList<>();
    }

    public Question(String text, List<Response> responses) {
        this.text = text;
        this.responses = responses;
    }
}
