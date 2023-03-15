package ru.itis.service;

import ru.itis.model.Actor;
import ru.itis.model.RoleActor;

import java.util.List;

public interface RoleService {
    RoleActor findDistinctFirstByActor(Actor actor);

    List<RoleActor> findTopByActorIn(List<Actor> actors);
}
