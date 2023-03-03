package ru.itis.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.model.Actor;
import ru.itis.model.Director;
import ru.itis.service.ActorService;

import java.util.List;

@Service
@AllArgsConstructor
public class ActorServiceImpl implements ActorService {
    private final ActorService actorService;

    @Override
    public Actor findActorByDirector(Director director) {
        return findActorByDirector(director);
    }

    @Override
    public Actor findActorByName(String name) {
        return findActorByName(name);
    }

    @Override
    public List<Actor> findAllByName(String name) {
        return findAllByName(name);
    }
}
