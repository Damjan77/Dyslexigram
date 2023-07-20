package com.example.dyslexigram.service;

import com.example.dyslexigram.model.Game;
import com.example.dyslexigram.model.User;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    List<User> listAllUsers();

    User findById(Long id);

    User findByNickname(String nickname);

    Optional<User> save(String nickname);

    User edit(Long id, String nickname);

    void deleteUser(Long id);

    boolean userExists(String nickname);

    void saveFinishedGame(User user, Game game);
}
