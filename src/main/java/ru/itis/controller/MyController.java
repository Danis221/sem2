package ru.itis.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.model.Actor;
import ru.itis.model.Director;
import ru.itis.model.Film;
import ru.itis.model.Role;
import ru.itis.service.ActorService;
import ru.itis.service.DirectorService;
import ru.itis.service.FilmService;
import ru.itis.service.RoleService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class MyController {
    private final ActorService actorService;
    private final DirectorService directorService;
    private final FilmService filmService;
    private final RoleService roleService;

    @GetMapping("/actor/{name}")
    public Actor fin(@PathVariable String name) {
        return actorService.findActorByName(name);
    }

    @GetMapping("/director/{id}")
    public void deleteDirector(@PathVariable Optional<Integer> id) {
        directorService.deleteDirectorBuId(id.orElseThrow(IllegalArgumentException::new));
    }

    @GetMapping("/forewer")
    public List<Film> findAllByBoxOfficeIsLessThan(Long boxOffice) {
        return filmService.findAllByBoxOfficeIsLessThan(boxOffice);
    }

    @GetMapping("/forewer2")
    public Role findDistinctFirstByActor(Actor actor) {
        return roleService.findDistinctFirstByActor(actor);
    }

}
