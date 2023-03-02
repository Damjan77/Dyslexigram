package com.example.dyslexigram.repository;

import com.example.dyslexigram.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {
}
