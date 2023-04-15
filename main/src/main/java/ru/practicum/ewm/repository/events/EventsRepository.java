package ru.practicum.ewm.repository.events;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.practicum.ewm.model.events.Event;
import ru.practicum.ewm.model.events.State;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Repository
public interface EventsRepository extends JpaRepository<Event, Integer> {
    List<Event> findAllByInitiatorId(Integer userId, Pageable pageable);

    Optional<Event> findByInitiatorIdAndId(Integer initiatorId, Integer id);

    @Query("SELECT e " +
            "FROM Event AS e " +
            "WHERE " +
            "(" +
            ":text IS NULL " +
            "OR LOWER(e.description) LIKE CONCAT('%', :text, '%') " +
            "OR LOWER(e.annotation) LIKE CONCAT('%', :text, '%')" +
            ")" +
            "AND (:states IS NULL OR e.state IN (:states)) " +
            "AND (:categories IS NULL OR e.category.id IN (:categories)) " +
            "AND (:paid IS NULL OR e.paid = :paid) " +
            "AND (CAST(:rangeStart AS date) IS NULL OR e.eventDate >= :rangeStart) " +
            "AND (CAST(:rangeEnd AS date) IS NULL OR e.eventDate <= :rangeEnd) " +
            "order by e.eventDate")
    List<Event> findByParamsOrderByDate(
            @Param("text") String text,
            @Param("states") List<State> states,
            @Param("categories") List<Integer> categories,
            @Param("paid") Boolean paid,
            @Param("rangeStart") LocalDateTime rangeStart,
            @Param("rangeEnd") LocalDateTime rangeEnd,
            Pageable pageable);
}
