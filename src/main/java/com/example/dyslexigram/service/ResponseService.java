package com.example.dyslexigram.service;
import com.example.dyslexigram.model.Response;

import java.util.List;
import java.util.Optional;

public interface ResponseService {

    List<Response> listAllResponses();

    Response findById(Long id);

    Optional<Response> save(String text);

    Response delete(Long id);
}
