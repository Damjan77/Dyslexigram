package com.example.dyslexigram.service;

import com.example.dyslexigram.model.Game;
import com.example.dyslexigram.model.Question;
import com.example.dyslexigram.model.enumerations.Level;

import java.util.List;
import java.util.Optional;

public interface GameService {

    List<Game> listAllGames();

    Game findById(Long id);

    Game findByTitle(String title);

    Optional<Game> save(String title, String description, Level level, String imgUrl, Question question);

    Game edit(Long id, String title, String description, Level level, String imgUrl, Question question);

    Game delete(Long id);
}
