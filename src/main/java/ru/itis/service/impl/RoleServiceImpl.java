package ru.itis.service.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.model.Actor;
import ru.itis.model.RoleActor;
import ru.itis.repository.RoleRepository;
import ru.itis.service.RoleService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public RoleActor findDistinctFirstByActor(Actor actor) {
        return roleRepository.findDistinctFirstByActor(actor);
    }

    @Override
    public List<RoleActor> findTopByActorIn(List<Actor> actors) {
        return roleRepository.findTopByActorIn(actors);
    }
}
