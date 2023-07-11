package com.example.dyslexigram.web;

import com.example.dyslexigram.model.Game;
import com.example.dyslexigram.model.User;
import com.example.dyslexigram.service.GameService;
import com.example.dyslexigram.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProfileController {
    private final UsersService usersService;
    private final GameService gameService;

    public ProfileController(UsersService usersService, GameService gameService) {
        this.usersService = usersService;
        this.gameService = gameService;
    }

    @GetMapping("/profile")
    public String getProfilePage(Model model,
                                 HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String nickname = null;
        if (cookies != null){
            nickname = Arrays.stream(request.getCookies())
                    .filter(cookie -> cookie.getName().equals("nickname"))
                    .findFirst()
                    .map(Cookie::getValue).orElse(null);
        }

        if (nickname == null) {
            return "redirect:/login";
        }

        List<Game> games = this.gameService.listAllGames();

        model.addAttribute("link", 4);
        model.addAttribute("games", games);

        User user = this.usersService.findByNickname(nickname.replace("+", " "));
        model.addAttribute("user", user);

        return "profile";
    }
}
