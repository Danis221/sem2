package ru.itis.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.model.Actor;
import ru.itis.model.Role;
import ru.itis.repository.RoleRepository;
import ru.itis.service.RoleService;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role findDistinctFirstByActor(Actor actor) {
        return roleRepository.findDistinctFirstByActor(actor);
    }

    @Override
    public List<Role> findTopByActorIn(List<Actor> actors) {
        return roleRepository.findTopByActorIn(actors);
    }
}
