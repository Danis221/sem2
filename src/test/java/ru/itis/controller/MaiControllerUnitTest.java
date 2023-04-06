package ru.itis.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ru.itis.service.UserService;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MainController.class)
@ExtendWith(SpringExtension.class)
public class MaiControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HttpServletRequest httpServletRequest;

    @MockBean
    private UserService userService;

    @Test
    public void testSignUp() throws Exception {
        mockMvc.perform(get("/sign_up")
                        .with(user("user").roles("ADMIN")))
                .andExpect(status().isOk())
                .andExpect(view().name("sign_up"))
                .andExpect(model().attributeExists("user"))
                .andReturn();
    }

    @Test
    public void testIndex() throws Exception {
        MvcResult result = mockMvc.perform(get("/")
                        .with(user("user").roles("ADMIN")))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andReturn();
    }

    @Test
    public void testArticlesEndpoint() throws Exception {
        mockMvc.perform(get("/articles")
                        .with(user("user").roles("ADMIN")))
                .andExpect(status().isOk())
                .andExpect(view().name("articles"));
    }

}