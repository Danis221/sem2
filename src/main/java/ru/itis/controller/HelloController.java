package ru.itis.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.model.User;
import ru.itis.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class HelloController {

    private final UserRepository userRepository;

    @GetMapping(value = {"/users/{id}", "users"})
    public Iterable<User> user(@PathVariable(required = false) Optional<Integer> id) {
        if (id.isPresent()) {
            return userRepository.findAllById(List.of(id.get()));
        } else {
            return userRepository.findAll();
        }
    }

    @GetMapping("/users/create")
    public void create(@RequestParam Optional<String> name, @RequestParam Optional<String> email) {
        if (name.isPresent() && email.isPresent()) {
            userRepository.save(User.builder()
                    .email(email.get())
                    .name(name.get())
                    .build());
        }
    }

    @GetMapping("users/delete")
    public void delete(@RequestParam int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }

    @GetMapping("users/update")
    public void update(@RequestParam Optional<Integer> id, @RequestParam Optional<String> name, @RequestParam Optional<String> email) {
        if (id.isPresent() && name.isPresent() && email.isPresent()) {
            if (userRepository.existsById(id.get())) {
                User oldUser = userRepository.findById(id.get()).get();
                oldUser.setName(name.get());
                oldUser.setEmail(email.get());
                userRepository.save(oldUser);
            }
        }
    }


    @GetMapping("/hello")
    public String hello(@RequestParam Optional<String> name) {
        return String.format("Hello, %s!", name.orElse("Ivan"));
    }
}

