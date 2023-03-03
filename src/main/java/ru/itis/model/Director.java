package ru.itis.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "directors")
@Getter
@Setter
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(nullable = false)
    private String name;


    @Column(nullable = false)
    private Integer old;


    @OneToMany(mappedBy = "director")
    private List<Actor> actors;

    @ManyToMany
    @JoinTable(
            name = "directors_films",
            joinColumns = @JoinColumn(name = "director_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id")
    )
    private List<Film> films;

}
