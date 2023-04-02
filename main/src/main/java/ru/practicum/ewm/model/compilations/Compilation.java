package ru.practicum.ewm.model.compilations;

import javax.persistence.*;

@Entity
@Table(name = "COMPILATIONS")
public class Compilation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private Boolean pinned;

    private String title;

}
