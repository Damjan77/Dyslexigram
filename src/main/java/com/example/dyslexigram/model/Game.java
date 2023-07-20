package com.example.dyslexigram.model;

import com.example.dyslexigram.model.enumerations.Level;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Game {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String Description;
    @Enumerated(value = EnumType.STRING)
    private Level level;
    private String img_url;
    private int points;

    @ManyToMany
    private List<Question> questions;

    public Game() {
    }

    public Game(String title, String description, Level level, String img_url, List<Question> questions) {
        this.title = title;
        Description = description;
        this.level = level;
        this.img_url = img_url;
        this.questions = questions;
    }


    public Game(String title, String description, Level level, String img_url, int points, List<Question> questions) {
        this.title = title;
        Description = description;
        this.level = level;
        this.img_url = img_url;
        this.points = points;
        this.questions = questions;
    }

}
