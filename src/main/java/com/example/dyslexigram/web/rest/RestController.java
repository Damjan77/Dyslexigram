package com.example.dyslexigram.web.rest;

import com.example.dyslexigram.model.Game;
import com.example.dyslexigram.model.Question;
import com.example.dyslexigram.service.GameService;
import com.example.dyslexigram.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    private final QuestionService questionService;
    private final GameService gameService;

    public RestController(QuestionService questionService, GameService gameService) {
        this.questionService = questionService;
        this.gameService = gameService;
    }

    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return this.questionService.listAllQuestions();
    }

    @GetMapping("/questions/{gameId}")
    public List<Question> getAllQuestionsByGame(@PathVariable Long gameId) {
        Game game = this.gameService.findById(gameId);
        return this.questionService.findAllByGame(game);
    }
}
