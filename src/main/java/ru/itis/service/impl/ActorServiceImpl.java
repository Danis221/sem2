package ru.itis.service.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.model.Actor;
import ru.itis.model.Director;
import ru.itis.repository.ActorRepository;
import ru.itis.service.ActorService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {


    private final ActorRepository actorRepository;

    @Override
    public Actor findActorByDirector(Director director) {
        return actorRepository.findActorByDirector(director);
    }

    @Override
    public Actor findActorByName(String name) {
        return actorRepository.findActorByName(name);
    }

    @Override
    public List<Actor> findAllByName(String name) {
        return actorRepository.findAllByName(name);
    }
}
