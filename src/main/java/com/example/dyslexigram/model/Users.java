package com.example.dyslexigram.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Data
public class Users {
    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private int total_points;

    public Users() {
    }

    public Users(String nickname, int total_points) {
        this.nickname = nickname;
        this.total_points = total_points;
    }
}
