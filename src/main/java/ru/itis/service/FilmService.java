package ru.itis.service;

import ru.itis.model.Film;
import java.util.List;

public interface FilmService {
    List<Film> findAllByBoxOfficeIsLessThan(Long boxOffice);

    List<Film> searchAllByNameIsStartingWith(String name);
}
