package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Actor;
import ru.itis.model.Director;

import java.util.List;

public interface DirectorRepository extends JpaRepository<Director, Integer> {
    Integer countAllByActors(List<Actor> actors);

    Director getDistinctById(Integer id);

}
