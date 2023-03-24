package ru.itis.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.CreateUserRequestDto;
import ru.itis.dto.UserResponseDto;
import ru.itis.service.UserService;
import ru.itis.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

import static ru.itis.dto.UserResponseDto.fromEntity;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseBody
    @GetMapping(value = {"/users/{id}", "users"})
    public List<UserResponseDto> user(@PathVariable(required = false) Optional<Integer> id) {
        if (id.isPresent()) {
            return List.of(userService.findById(id.get()).get());
        } else {
            return userService.findAll();
        }
    }


    @PostMapping("/user")
    public String createUser(@ModelAttribute CreateUserRequestDto user, HttpServletRequest request) {
        String url = request.getRequestURL().toString().replace(request.getServletPath(), "");
        userService.create(user, url);
        return "sign_up_success";
    }

    @GetMapping("/verification")
    public String verify(@Param("code") String code) {
        if (userService.verify(code)) {
            return "verification_success";
        } else {
            return "verification_fall";
        }
    }
}