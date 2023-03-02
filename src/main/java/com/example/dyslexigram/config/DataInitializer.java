package com.example.dyslexigram.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class DataInitializer {

    @PostConstruct
    public void init() {

    }
}
