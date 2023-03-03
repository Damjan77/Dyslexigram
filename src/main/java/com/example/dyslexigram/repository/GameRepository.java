package com.example.dyslexigram.repository;

import com.example.dyslexigram.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {
    Game findByTitle(String title);
}
