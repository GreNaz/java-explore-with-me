package ru.practicum.ewm.model.compilations;

import lombok.*;
import ru.practicum.ewm.model.events.Event;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "COMPILATIONS")
public class Compilation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private Boolean pinned;

    private String title;

    @ManyToMany
    @JoinColumn(name = "events_id")
    private Set<Event> events;

}
