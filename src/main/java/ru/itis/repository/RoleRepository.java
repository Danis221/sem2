package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Actor;
import ru.itis.model.RoleActor;

import java.util.List;

public interface RoleRepository extends JpaRepository<RoleActor, Integer> {
    RoleActor findDistinctFirstByActor(Actor actor);

    List<RoleActor> findTopByActorIn(List<Actor> actors);
}
