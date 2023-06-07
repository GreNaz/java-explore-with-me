package ru.practicum.ewm.model.events;

import lombok.*;
import ru.practicum.ewm.model.Location;
import ru.practicum.ewm.model.categories.Category;
import ru.practicum.ewm.model.users.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EVENTS")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "annotation", nullable = false, length = 2000)
    private String annotation;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE NOT NULL")
    private LocalDateTime createdOn;

    @Column(length = 5000)
    private String description;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE NOT NULL")
    private LocalDateTime eventDate;

    @ManyToOne
    @JoinColumn(name = "initiator_id", nullable = false)
    private User initiator;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean paid;

    @Column(columnDefinition = "Integer DEFAULT 0")
    private Long participantLimit;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE NOT NULL")
    private LocalDateTime publishedOn;

    @Column(columnDefinition = "Boolean DEFAULT TRUE")
    private Boolean requestModeration;

    @Column(length = 20, columnDefinition = "varchar(20) DEFAULT 'PENDING'")
    @Enumerated(EnumType.STRING)
    private State state;

    @Column(nullable = false, length = 500)
    private String title;

    private Integer views;
}
