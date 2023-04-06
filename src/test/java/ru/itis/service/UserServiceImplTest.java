package ru.itis.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import ru.itis.config.MailConfig;
import ru.itis.dto.CreateUserRequestDto;
import ru.itis.dto.UserResponseDto;
import ru.itis.model.User;
import ru.itis.repository.UserRepository;
import ru.itis.service.UserService;
import ru.itis.service.impl.UserServiceImpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder encoder;

    @Mock
    private JavaMailSender javaMailSender;

    @Mock
    private MailConfig mailConfig;

    @InjectMocks
    private UserServiceImpl userService;

    private CreateUserRequestDto createUserDto;
    private User user;
    private List<User> userList;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        createUserDto = CreateUserRequestDto.builder()
                .name("testuser")
                .email("testuser@test.com")
                .password("password")
                .build();

        user = User.builder()
                .name(createUserDto.getName())
                .email(createUserDto.getEmail())
                .password(createUserDto.getPassword())
                .build();

        userList = Arrays.asList(user);
    }

    @Test
    public void testFindAll() {
        when(userRepository.findAll()).thenReturn(userList);

        List<UserResponseDto> userResponseDtoList = userService.findAll();

        assertEquals(userList.size(), userResponseDtoList.size());
        assertEquals(userList.get(0).getId(), userResponseDtoList.get(0).getId());
        assertEquals(userList.get(0).getName(), userResponseDtoList.get(0).getName());
        assertEquals(userList.get(0).getEmail(), userResponseDtoList.get(0).getEmail());

        Mockito.verify(userRepository, times(1)).findAll();
    }


    @Test
    public void testCreate() throws MessagingException, UnsupportedEncodingException {
        when(encoder.encode(createUserDto.getPassword())).thenReturn("encodedPassword");
        when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);

        String verificationUrl = "http://localhost:8080";

        userService.create(createUserDto, verificationUrl);

        Mockito.verify(userRepository, times(1)).save(ArgumentMatchers.any(User.class));
        Mockito.verify(javaMailSender, times(1)).send(ArgumentMatchers.any(MimeMessage.class));
    }

    @Test
    public void testFindById() {
        User user = new User();
        user.setName("John");
        user.setEmail("john@example.com");
        when(userRepository.findAllById(List.of(1))).thenReturn(List.of(user));

        Optional<UserResponseDto> result = userService.findById(1);


        assertTrue(result.isPresent());
        assertEquals("John", result.get().getName());
        assertEquals("john@example.com", result.get().getEmail());
    }
}