package com.example.dyslexigram.service.impl;

import com.example.dyslexigram.model.Game;
import com.example.dyslexigram.model.Question;
import com.example.dyslexigram.model.enumerations.Level;
import com.example.dyslexigram.model.exceptions.InvalidGameIdException;
import com.example.dyslexigram.repository.GameRepository;
import com.example.dyslexigram.service.GameService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Game> listAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public Game findById(Long id) {
        return gameRepository.findById(id).orElseThrow(InvalidGameIdException::new);
    }

    @Override
    public List<Game> findAllByTitle(String title) {
        return gameRepository.findAllByTitleContainingIgnoreCase(title);
    }

    @Override
    public Optional<Game> save(String title, String description, Level level, String imgUrl, List<Question> questions) {
        Game game = new Game(title,description,level,imgUrl,questions);

        return Optional.of(gameRepository.save(game));
    }

    @Override
    public Game edit(Long id, String title, String description, Level level, String imgUrl, List<Question> questions) {
        Game game = this.findById(id);
        game.setTitle(title);
        game.setDescription(description);
        game.setLevel(level);
        game.setImg_url(imgUrl);
        game.setQuestions(questions);

        return this.gameRepository.save(game);
    }

    @Override
    public Game delete(Long id) {
        Game game = findById(id);
        this.gameRepository.delete(game);

        return game;
    }
}
