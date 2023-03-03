package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Actor;
import ru.itis.model.Director;
import ru.itis.model.Role;

import java.util.List;

interface ActorRepository extends JpaRepository<Actor, Integer> {
    Actor findActorByDirector(Director director);

    Actor findActorByName(String name);

     List<Actor> findAllByName(String name);

}
