package com.example.dyslexigram.service;

import com.example.dyslexigram.model.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    List<Users> listAllUsers();

    Users findById(Long id);

    Users findByNickname(String nickname);

    Optional<Users> save(String nickname, int total_points);

    Users edit(Long id, String nickname, int total_points);

    void deleteUser(Long id);
}
