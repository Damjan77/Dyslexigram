package com.example.dyslexigram.web;

import com.example.dyslexigram.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.http.HttpResponse;

@Controller
@RequestMapping("/games")
public class GamesController {

    private final UsersService usersService;

    public GamesController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/test")
    public String getGamesPageForTestingPurposes(Model model) {
        model.addAttribute("link", 2);
        model.addAttribute("user", "Име на корисник");

        return "games";
    }

    @GetMapping()
    public String getGamesPage(Model model,
                               HttpServletRequest request) {

        // Check if nickname exists in cookie
        Cookie[] cookies = request.getCookies();
        String nickname = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("nickname")) {
                    nickname = cookie.getValue();
                    break;
                }
            }
        }

        // If nickname not found, redirect to enter nickname page
        if (nickname == null) {
            return "redirect:/login";
        }

        model.addAttribute("link", 2);
        model.addAttribute("user", nickname);

        return "games";
    }

    @PostMapping("/enter-nickname")
    public String saveUser(Model model,
                           @RequestParam String user,
                           HttpServletResponse response) {

        //save nickname in cookie
        Cookie cookie = new Cookie("nickname", user);
        cookie.setMaxAge(1800); // set cookie to last for 30 minutes (1800 sec), after 30 minutes you need to enter nickname again
        response.addCookie(cookie);

        this.usersService.save(user, 0);
        model.addAttribute("link", 2);
        return "redirect:/games";
    }




}
