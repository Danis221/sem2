package ru.itis.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.CreateUserRequestDto;
import ru.itis.dto.UserResponseDto;
import ru.itis.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Optional;

import static ru.itis.dto.UserResponseDto.fromEntity;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

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
    public String createUser(@ModelAttribute CreateUserRequestDto user) {
        userService.create(user);
        return "sign_up_success";
    }
}