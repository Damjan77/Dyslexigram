package com.example.dyslexigram.web;

import com.example.dyslexigram.model.User;
import com.example.dyslexigram.service.UsersService;
import com.sun.xml.bind.v2.TODO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/games")
public class GamesController {

    private final UsersService usersService;

    public GamesController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public String getGamesPageForTestingPurposes(Model model) {
        model.addAttribute("link", 2);
        model.addAttribute("user", "Име на корисник");

        return "games";
    }

    @GetMapping("/{user}")
    public String getGamesPageWithUser(Model model, @PathVariable String user) {
        this.usersService.save(user, 0);

        model.addAttribute("link", 2);
        model.addAttribute("user", user);
        return "games";
    }

    //TODO: check if user is already logged in
    @PostMapping("/login")
    public String getGamesPage(Model model, @RequestParam String user) {
        model.addAttribute("link", 2);
        return "redirect:/games/" + user;
    }




}
