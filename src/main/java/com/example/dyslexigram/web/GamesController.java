package com.example.dyslexigram.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/games")
public class GamesController {

    @GetMapping()
    public String getHomePage(Model model) {
        model.addAttribute("link", 2);
        return "games";
    }
}
