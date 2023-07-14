package com.example.dyslexigram.service;

import com.example.dyslexigram.model.Game;
import com.example.dyslexigram.model.Question;
import com.example.dyslexigram.model.Response;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<Question> listAllQuestions();

    Question findById(Long id);

    List<Question> findAllByGame(Game game);

    Optional<Question> save(String text, String audioPath,List<Response> responses, Response correct_answer);

    Question delete(Long id);
}
