package com.example.dyslexigram.repository;

import com.example.dyslexigram.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
