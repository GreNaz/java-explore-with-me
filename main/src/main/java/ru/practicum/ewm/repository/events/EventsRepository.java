package ru.practicum.ewm.repository.events;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.ewm.model.events.Event;


@Repository
public interface EventsRepository extends JpaRepository<Event, Integer> {
}
