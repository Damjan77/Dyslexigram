package com.example.dyslexigram.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping({"/", "/home"})
    public String getHomePage(Model model) {
        model.addAttribute("link", 1);
        return "home.html";
    }

    @GetMapping( "/info")
    public String getInfoPage(Model model) {
        model.addAttribute("link", 3);
        return "info";
    }
}
