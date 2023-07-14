package com.example.dyslexigram.service.impl;

import com.example.dyslexigram.model.Game;
import com.example.dyslexigram.model.Question;
import com.example.dyslexigram.model.Response;
import com.example.dyslexigram.model.exceptions.InvalidQuestionIdException;
import com.example.dyslexigram.repository.QuestionRepository;
import com.example.dyslexigram.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> listAllQuestions() {
        return this.questionRepository.findAll();
    }

    @Override
    public Question findById(Long id) {
        return this.questionRepository.findById(id).orElseThrow(InvalidQuestionIdException::new);
    }

    @Override
    public List<Question> findAllByGame(Game game) {
        return game.getQuestions();
    }

    @Override
    public Optional<Question> save(String text, String audioPath,List<Response> responses, Response correct_answer) {
        Question question = new Question(text,audioPath,responses,correct_answer);

        return Optional.of(this.questionRepository.save(question));
    }

    @Override
    public Question delete(Long id) {
        Question question = this.findById(id);
        this.questionRepository.delete(question);

        return question;
    }
}
