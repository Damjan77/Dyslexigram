package com.example.dyslexigram.service.impl;

import com.example.dyslexigram.model.Game;
import com.example.dyslexigram.model.User;
import com.example.dyslexigram.model.exceptions.InvalidUserIdException;
import com.example.dyslexigram.model.exceptions.UserNotFoundException;
import com.example.dyslexigram.repository.UsersRepository;
import com.example.dyslexigram.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<User> listAllUsers() {
        return this.usersRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return this.usersRepository.findById(id).orElseThrow(InvalidUserIdException::new);
    }

    @Override
    public User findByNickname(String nickname) {
        return this.usersRepository.findByNickname(nickname).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public Optional<User> save(String nickname) {
        User userTosave = new User(nickname);

        return Optional.of(this.usersRepository.save(userTosave));
    }

    @Override
    public User edit(Long id, String nickname) {
        User userToEdit = this.findById(id);
        userToEdit.setNickname(nickname);
        return this.usersRepository.save(userToEdit);
    }

    //Eden vid na implementacija. Ako ne raboti, moze da se implementira so .delete(istanca od user)
    @Override
    public void deleteUser(Long id) {
        if(id == null) throw new IllegalArgumentException();
        this.usersRepository.deleteById(id);
    }

    @Override
    public boolean userExists(String nickname) {
        return this.usersRepository.findByNickname(nickname).isPresent();
    }

    @Override
    public void saveFinishedGame(User user, Game game) { //ALELUJAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
        List<Game> finishedGamesList = user.getFinishedGames();
        finishedGamesList.add(game);
        user.setFinishedGames(finishedGamesList);
        this.usersRepository.save(user);
    }
}
