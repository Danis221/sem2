package ru.itis.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "actors")
@Getter
@Setter
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer old;

    @OneToOne(mappedBy = "actor")
    private RoleActor roleActor;

    @ManyToOne()
    @JoinColumn(name = "director_id")
    private Director director;

}
