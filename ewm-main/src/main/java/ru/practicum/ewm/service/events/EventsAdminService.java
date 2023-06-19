package ru.practicum.ewm.service.events;

import ru.practicum.ewm.model.events.State;
import ru.practicum.ewm.model.events.dto.EventFullDto;
import ru.practicum.ewm.model.events.dto.UpdateEventAdminRequest;

import javax.transaction.Transactional;
import java.util.List;

public interface EventsAdminService {
    List<EventFullDto> getEvents(
            List<Integer> users,
            List<Integer> categories,
            List<State> states,
            String rangeStart,
            String rangeEnd,
            Integer from,
            Integer size
    );

    @Transactional
    EventFullDto updateEvent(
            UpdateEventAdminRequest updateEventAdminRequest,
            Long eventId);
}
