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
//    @OneToMany
//    private List<UserGamePoints> userGamePointsList = new ArrayList<>();

    public User() {
    }

    public User(String nickname) {
        this.nickname = nickname;
    }
}
