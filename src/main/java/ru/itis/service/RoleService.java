package ru.itis.service;

import ru.itis.model.Actor;
import ru.itis.model.Role;

import java.util.List;

public interface RoleService {
    Role findDistinctFirstByActor(Actor actor);

    List<Role> findTopByActorIn(List<Actor> actors);
}
