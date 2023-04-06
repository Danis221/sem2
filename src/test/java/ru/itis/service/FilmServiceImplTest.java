package ru.itis.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.itis.model.Film;
import ru.itis.repository.FilmRepository;
import ru.itis.service.impl.FilmServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FilmServiceImplTest {

    private FilmServiceImpl filmService;

    @Mock
    private FilmRepository filmRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        filmService = new FilmServiceImpl(filmRepository);
    }

    @Test
    public void testFindAllByBoxOfficeIsLessThan() {
        Long boxOffice = 500000000L;
        List<Film> expectedFilms = Arrays.asList(new Film(), new Film());
        when(filmRepository.findAllByBoxOfficeIsLessThan(boxOffice)).thenReturn(expectedFilms);

        List<Film> result = filmService.findAllByBoxOfficeIsLessThan(boxOffice);

        assertEquals(expectedFilms, result);
    }

    @Test
    public void testSearchAllByNameIsStartingWith() {
        String name = "The";
        List<Film> expectedFilms = Arrays.asList(new Film(), new Film());
        when(filmRepository.searchAllByNameIsStartingWith(name)).thenReturn(expectedFilms);

        List<Film> result = filmService.searchAllByNameIsStartingWith(name);

        assertEquals(expectedFilms, result);
    }
}
