package com.example.dyslexigram.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


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
