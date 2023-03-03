package com.example.dyslexigram.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class Question {
    @Id
    @GeneratedValue
    Long id;
    String text;
    String audioPath;

    @OneToMany
    private List<Response> responses;
    @OneToOne
    private Response correct_answer;

    public Question() {
        responses = new ArrayList<>();
    }

    public Question(String text,String audioPath, List<Response> responses, Response correct_answer) {
        this.text = text;
        this.audioPath = audioPath;
        this.responses = responses;
        this.correct_answer = correct_answer;
    }
}
