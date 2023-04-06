package ru.itis.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import ru.itis.controller.UserController;
import ru.itis.dto.CreateUserRequestDto;
import ru.itis.dto.UserResponseDto;
import ru.itis.model.User;
import ru.itis.repository.UserRepository;
import ru.itis.service.UserService;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(UserController.class)
@ExtendWith(SpringExtension.class)
public class UserControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    public UserControllerUnitTest() {
    }

    @Test
    public void testGetUser() throws Exception {

        User user = new User();
        user.setName("Данис");
        given(userService.findAll()).willReturn(List.of(UserResponseDto.fromEntity(user)));

        mockMvc.perform(get("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .with(user("user").roles("ADMIN")))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name").value("Данис"));
    }

    @Test
    public void testVerifySuccess() throws Exception {
        String code = "validCode";

        given(userService.verify(code)).willReturn(true);

        mockMvc.perform(get("/verification").param("code", code))
                .andExpect(status().isOk())
                .andExpect(view().name("verification_success"));
    }

    @Test
    public void testVerifyFail() throws Exception {
        String code = "invalidCode";

        given(userService.verify(code)).willReturn(false);

        mockMvc.perform(get("/verification").param("code", code)
                        .with(user("user").authorities()))
                .andExpect(status().isOk())
                .andExpect(view().name("verification_fail"));
    }

}
