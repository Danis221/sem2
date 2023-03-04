package ru.itis.service;

import ru.itis.model.Actor;
import ru.itis.model.Director;
import java.util.List;

public interface DirectorService {
    Integer countAllByActors(List<Actor> actors);

    Director getDistinctById(Integer id);

    void deleteDirectorBuId(Integer id);
}
