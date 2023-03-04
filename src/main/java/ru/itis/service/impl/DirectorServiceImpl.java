package ru.itis.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.model.Actor;
import ru.itis.model.Director;
import ru.itis.service.DirectorService;

import java.util.List;

@Service
@AllArgsConstructor
public class DirectorServiceImpl implements DirectorService {
    private final DirectorService directorService;

    @Override
    public Integer countAllByActors(List<Actor> actors) {
        return directorService.countAllByActors(actors);
    }

    @Override
    public Director getDistinctById(Integer id) {
        return directorService.getDistinctById(id);
    }

    @Override
    public void deleteDirectorBuId(Integer id) {
        directorService.deleteDirectorBuId(id);
    }
}
