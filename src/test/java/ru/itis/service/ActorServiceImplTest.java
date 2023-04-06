package ru.itis.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.itis.model.Actor;
import ru.itis.model.Director;
import ru.itis.repository.ActorRepository;
import ru.itis.service.impl.ActorServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ActorServiceImplTest {

    private ActorServiceImpl actorService;

    @Mock
    private ActorRepository actorRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        actorService = new ActorServiceImpl(actorRepository);
    }

    @Test
    public void testFindActorByDirector() {
        Director director = new Director();
        Actor expectedActor = new Actor();
        when(actorRepository.findActorByDirector(director)).thenReturn(expectedActor);

        Actor result = actorService.findActorByDirector(director);

        assertEquals(expectedActor, result);
    }

    @Test
    public void testFindActorByName() {
        String name = "Tom Hanks";
        Actor expectedActor = new Actor();
        when(actorRepository.findActorByName(name)).thenReturn(expectedActor);

        Actor result = actorService.findActorByName(name);

        assertEquals(expectedActor, result);
    }

    @Test
    public void testFindAllByName() {
        String name = "Brad Pitt";
        List<Actor> expectedActors = Arrays.asList(new Actor(), new Actor());
        when(actorRepository.findAllByName(name)).thenReturn(expectedActors);

        List<Actor> result = actorService.findAllByName(name);

        assertEquals(expectedActors, result);
    }
}
