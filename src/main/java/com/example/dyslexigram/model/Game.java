package com.example.dyslexigram.model;

import com.example.dyslexigram.model.enumerations.Level;
import lombok.Data;

import javax.persistence.*;

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

    @ManyToOne
    private Question question;

    public Game() {

    }

    public Game(String title, String description, Level level, String img_url, Question question) {
        this.title = title;
        Description = description;
        this.level = level;
        this.img_url = img_url;
        this.question = question;
    }
}
