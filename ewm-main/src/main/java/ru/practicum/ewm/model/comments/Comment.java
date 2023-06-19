package ru.practicum.ewm.model.comments;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import ru.practicum.ewm.model.events.Event;
import ru.practicum.ewm.model.users.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "COMMENTS")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @ManyToOne(fetch = FetchType.LAZY)
    private Event event;
    @ManyToOne(fetch = FetchType.LAZY)
    private User author;
    @CreationTimestamp
    private LocalDateTime created;
    @Enumerated(value = EnumType.STRING)
    private CommentState commentState;
    private LocalDateTime published;
}
