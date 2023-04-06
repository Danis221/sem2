package ru.itis.service.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.model.Film;
import ru.itis.repository.FilmRepository;
import ru.itis.service.FilmService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;
    @Override
    public List<Film> findAllByBoxOfficeIsLessThan(Long boxOffice) {
        return filmRepository.findAllByBoxOfficeIsLessThan(boxOffice);
    }

    @Override
    public List<Film> searchAllByNameIsStartingWith(String name) {
        return filmRepository.searchAllByNameIsStartingWith(name);
    }
}
