package com.example.dyslexigram.service.impl;

import com.example.dyslexigram.model.Response;
import com.example.dyslexigram.model.exceptions.InvalidResponseIdException;
import com.example.dyslexigram.repository.ResponseRepository;
import com.example.dyslexigram.service.ResponseService;

import java.util.List;
import java.util.Optional;

public class ResponseServiceImpl implements ResponseService {

    private final ResponseRepository responseRepository;

    public ResponseServiceImpl(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    @Override
    public List<Response> listAllResponses() {
        return this.responseRepository.findAll();
    }

    @Override
    public Response findById(Long id) {
        return this.responseRepository.findById(id).orElseThrow(InvalidResponseIdException::new);
    }

    @Override
    public Optional<Response> save(String text) {
        Response response = new Response(text);

        return Optional.of(this.responseRepository.save(response));
    }

    @Override
    public Response delete(Long id) {
        Response response = this.findById(id);
        this.responseRepository.delete(response);

        return response;
    }
}
