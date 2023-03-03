package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Film;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    List<Film> findAllByBoxOfficeIsLessThan(Long boxOffice);

    List<Film> searchAllByNameIsStartingWith(String name);

}
