package ru.practicum.ewm.repository.events;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.ewm.model.events.Event;

import java.util.List;


@Repository
public interface EventsRepository extends JpaRepository<Event, Integer> {
    List<Event> findAllByInitiatorId(Integer userId, Pageable pageable);
}
