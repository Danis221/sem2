package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.dto.CreateUserRequestDto;
import ru.itis.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class MainController {

    UserService userService;

    @GetMapping("/home")
    public String home(HttpServletRequest httpServletRequest) {
        String currentPrincipalName = httpServletRequest.getUserPrincipal().getName();
        return"home";
    }

    @GetMapping("/")
    public String index() {
        return"index";
    }

    @GetMapping("/profile")
    public String profile(Model model, HttpServletRequest httpServletRequest) {
        String currentPrincipalName = httpServletRequest.getUserPrincipal().getName();
//        model.addAttribute("user", userService.findByEmail(currentPrincipalName));
        return"profile";
    }

    @GetMapping("/articles")
    public String articles() {
        return"articles";
    }
    @GetMapping("/sign_up")
    public String signUp(Model model) {
        model.addAttribute("user", new CreateUserRequestDto());
        return "sign_up";
    }
}