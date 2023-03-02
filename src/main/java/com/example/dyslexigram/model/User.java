package com.example.dyslexigram.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private int total_points;

    public User() {
    }

    public User(String nickname, int total_points) {
        this.nickname = nickname;
        this.total_points = total_points;
    }
}
