package ru.itis.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.itis.model.Actor;
import ru.itis.model.RoleActor;
import ru.itis.repository.RoleRepository;
import ru.itis.service.impl.RoleServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RoleServiceImplTest {

    private RoleServiceImpl roleService;

    @Mock
    private RoleRepository roleRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        roleService = new RoleServiceImpl(roleRepository);
    }

    @Test
    public void testFindDistinctFirstByActor() {
        Actor actor = new Actor();
        RoleActor expectedRoleActor = new RoleActor();
        when(roleRepository.findDistinctFirstByActor(actor)).thenReturn(expectedRoleActor);

        RoleActor result = roleService.findDistinctFirstByActor(actor);

        assertEquals(expectedRoleActor, result);
    }

    @Test
    public void testFindTopByActorIn() {
        Actor actor1 = new Actor();
        Actor actor2 = new Actor();
        List<Actor> actors = Arrays.asList(actor1, actor2);
        List<RoleActor> expectedRoleActors = Arrays.asList(new RoleActor(), new RoleActor());
        when(roleRepository.findTopByActorIn(actors)).thenReturn(expectedRoleActors);

        List<RoleActor> result = roleService.findTopByActorIn(actors);

        assertEquals(expectedRoleActors, result);
    }
}