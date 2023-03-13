package com.example.dyslexigram.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @GetMapping()
    public String getProfilePage(Model model) {
        model.addAttribute("link", 4);
        return "profile";
    }
}
