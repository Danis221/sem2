package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Actor;
import ru.itis.model.Director;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
    Actor findActorByDirector(Director director);

    Actor findActorByName(String name);

     List<Actor> findAllByName(String name);

}
