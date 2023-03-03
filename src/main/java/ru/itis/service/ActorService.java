package ru.itis.service;

import ru.itis.model.Actor;
import ru.itis.model.Director;

import java.util.List;

public interface ActorService {
    Actor findActorByDirector(Director director);

    Actor findActorByName(String name);

    List<Actor> findAllByName(String name);
}
