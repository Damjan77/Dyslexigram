package com.example.dyslexigram.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String nickname;

    @ManyToMany
    private List<Game> finishedGames;

    public User() {
    }

    public User(String nickname) {
        this.nickname = nickname;
        this.finishedGames = new ArrayList<>();
    }
}
