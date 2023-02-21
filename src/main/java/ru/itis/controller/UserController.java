package ru.itis.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.CreateUserRequestDto;
import ru.itis.dto.UserResponseDto;
import ru.itis.model.User;
import ru.itis.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;



    @GetMapping("/users/{id}")
    public List<UserResponseDto> user(@PathVariable(required = false) Optional<Integer> id){
        if (id.isPresent()) {
            return userRepository.findAllById(List.of(id.get()))
                    .stream()
                    .map(UserResponseDto::fromEntity)
                    .toList();
        } else {
            return userRepository.findAll()
                    .stream()
                    .map(UserResponseDto::fromEntity)
                    .toList();
        }
    }


    @PostMapping("/user/create")
    public void createUser(@Valid @ModelAttribute("user") CreateUserRequestDto user){
        userRepository.save(
                User.builder()
                        .name(user.getName().trim())
                        .secondName(user.getSecondname().trim())
                        .email(user.getEmail().trim())
                        .birth(user.getBirth())
                        .build()
        );
    }


}