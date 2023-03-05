package com.example.dyslexigram.config;

import com.example.dyslexigram.model.Game;
import com.example.dyslexigram.model.Response;
import com.example.dyslexigram.model.Question;
import com.example.dyslexigram.model.enumerations.Level;
import com.example.dyslexigram.repository.GameRepository;
import com.example.dyslexigram.repository.QuestionRepository;
import com.example.dyslexigram.repository.ResponseRepository;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataInitializer {

    private final GameRepository gameRepository;
    private final ResponseRepository responseRepository;
    private final QuestionRepository questionRepository;

    public DataInitializer(GameRepository gameRepository, ResponseRepository responseRepository, QuestionRepository questionRepository) {
        this.gameRepository = gameRepository;
        this.responseRepository = responseRepository;
        this.questionRepository = questionRepository;
    }

    @PostConstruct
    public void init() {
        Level level = Level.Ниво2;
        //String text,String audioPath, List<Response> responses, Response correct_answer
        Response  correctAnswer =  new Response("Nekoj text za response");
        responseRepository.save(correctAnswer);
        List<Response> responses = new ArrayList<>();
        responses.add(correctAnswer);
        Question question = new Question("text","audioo",responses,correctAnswer);
        questionRepository.save(question);
        Game game = new Game("title","desctiption",level,"img_url",question);

        this.gameRepository.save(game);
    }
}
