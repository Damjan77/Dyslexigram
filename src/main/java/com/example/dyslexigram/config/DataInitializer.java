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
import java.util.Arrays;
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
        Response response1 = new Response("А");
        Response response2 = new Response("Е");
        Response response3 = new Response("И");
        Response response4 = new Response("О");
        Response response5 = new Response("У");
        Response response6 = new Response("В");
        Response response7 = new Response("К");
        Response response8 = new Response("Ј");
        Response response9 = new Response("М");
        Response response10 = new Response("Д");

        this.responseRepository.save(response1);
        this.responseRepository.save(response2);
        this.responseRepository.save(response3);
        this.responseRepository.save(response4);
        this.responseRepository.save(response5);
        this.responseRepository.save(response6);
        this.responseRepository.save(response7);
        this.responseRepository.save(response8);
        this.responseRepository.save(response9);
        this.responseRepository.save(response10);

        List<Response> responseList = new ArrayList<>(Arrays.asList(response1,response2,response3,response4,response5, response6, response7, response8, response9, response10));

        Question question1 = new Question("П_НЕДЕЛНИК", "", responseList, response4);
        Question question2 = new Question("УЧИТ_ЛКА", "", responseList, response3);
        Question question3 = new Question("_ВТОМОБИЛ", "", responseList, response1);

        this.questionRepository.save(question1);
        this.questionRepository.save(question2);
        this.questionRepository.save(question3);

        List<Question> questionList = new ArrayList<>(Arrays.asList(question1,question2,question3));

        Game game1 = new Game("Погоди ја буквата",
                "Играта се состои од неколку зборови на кои им недостасуваат букви. Можете ли да погодете коjа буква недостасува?",
                Level.Ниво1, "/images/game.jpg", questionList);

        this.gameRepository.save(game1);

    }
}
