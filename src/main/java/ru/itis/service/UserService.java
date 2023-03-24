package ru.itis.service;

import ru.itis.dto.CreateUserRequestDto;
import ru.itis.dto.UserResponseDto;
import ru.itis.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserResponseDto> findAll();

    Optional<UserResponseDto> findById(Integer id);

    UserResponseDto create(CreateUserRequestDto userDto, String url);

    boolean verify(String verificationCode);

    void sendVerificationMail(String mail, String name, String code, String url);

    Optional<User> findByEmail(String email);

    UserResponseDto getByEmail(String email);
}