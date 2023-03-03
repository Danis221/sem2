package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Actor;
import ru.itis.model.Role;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findDistinctFirstByActor(Actor actor);

    List<Role> findTopByActorIn(List<Actor> actors);
}
