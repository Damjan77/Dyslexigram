package com.example.dyslexigram.service;

import com.example.dyslexigram.model.User;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    List<User> listAllUsers();

    User findById(Long id);

    User findByNickname(String nickname);

    Optional<User> save(String nickname, int total_points);

    User edit(Long id, String nickname, int total_points);

    void deleteUser(Long id);
}
