package com.example.dyslexigram.web;

import com.example.dyslexigram.model.Game;
import com.example.dyslexigram.model.User;
import com.example.dyslexigram.service.GameService;
import com.example.dyslexigram.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
@RequestMapping("/games")
public class GamesController {

    private final UsersService usersService;
    private final GameService gameService;

    public GamesController(UsersService usersService, GameService gameService) {
        this.usersService = usersService;
        this.gameService = gameService;
    }

    @GetMapping("/test")
    public String getGamesPageForTestingPurposes(Model model) {
        model.addAttribute("link", 2);
        model.addAttribute("user", "Име на корисник");

        return "games";
    }

    @GetMapping("/finishGame")
    public String getInfoPage(Model model) {
        model.addAttribute("link", "/profile.html");
        return "redirect:/profile.html";
    }

    @GetMapping()
    public String getGamesPage(@RequestParam(required = false) String searchTerm,
                               Model model,
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

        List<Game> games;

        if(searchTerm == null) {
            games = this.gameService.listAllGames();
        } else {
            games = this.gameService.findAllByTitle(searchTerm);
        }

        model.addAttribute("link", 2);
        model.addAttribute("games", games);

        User user = new User(nickname.replace("+", " "), 0);
        model.addAttribute("user", user);

        return "games";
    }

    @PostMapping("/enter-nickname")
    public String saveUser(Model model,
                           @RequestParam String user,
                           HttpServletResponse response) throws UnsupportedEncodingException {

        //not encoding the cookie value will result in exception if we add space character in the nickname
        String cookieEnc = URLEncoder.encode(user, StandardCharsets.UTF_8);

        //save nickname in cookie
        Cookie cookie = new Cookie("nickname", cookieEnc);
        cookie.setMaxAge(1800); // set cookie to last for 30 minutes (1800 sec), after 30 minutes you need to enter nickname again
        cookie.setPath("/"); //global cookie
        response.addCookie(cookie);

        this.usersService.save(user, 0);
        model.addAttribute("link", 2);
        return "redirect:/games";
    }

    @GetMapping("/{gameId}")
    public String playGame(Model model,
                           @PathVariable Long gameId) {
        Game game = this.gameService.findById(gameId);

        model.addAttribute("link", 0);
        model.addAttribute("game", game);
        return "game";
    }


    @GetMapping("/targetPage")
    public String targetPage() {
        return "targetPage";
    }


}
