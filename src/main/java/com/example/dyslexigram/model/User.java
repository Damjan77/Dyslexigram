package com.example.dyslexigram.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Data
@Table(name = "users")
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
