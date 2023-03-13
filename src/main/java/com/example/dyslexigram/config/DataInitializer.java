package com.example.dyslexigram.config;

import com.example.dyslexigram.model.Game;
import com.example.dyslexigram.model.Question;
import com.example.dyslexigram.model.Response;
import com.example.dyslexigram.model.enumerations.Level;
import com.example.dyslexigram.repository.GameRepository;
import com.example.dyslexigram.repository.QuestionRepository;
import com.example.dyslexigram.repository.ResponseRepository;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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
        List<Question> questionList = new ArrayList<>();
        Question question = new Question("text","audio",responses,correctAnswer);
        questionRepository.save(question);
        questionList.add(question);
        Game game = new Game("title","description",level,"img_url",questionList);

        this.gameRepository.save(game);
    }
}
