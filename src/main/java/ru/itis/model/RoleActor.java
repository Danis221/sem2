package ru.itis.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity(name = "roles_actor")
@Getter
@Setter
public class RoleActor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;
    
}
