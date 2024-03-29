package ru.itis.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "groups")
@Getter
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 16)
    private String name;

    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
    private List<User> users;

    @ManyToMany
    @JoinTable(
            name = "groups_subjects",
            joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id")
    )
    private List<Subject> subjects;
}

