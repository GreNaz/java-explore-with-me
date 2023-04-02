package ru.practicum.ewm.service.events;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.model.events.dto.EventFullDto;
import ru.practicum.ewm.model.events.dto.UpdateEventAdminRequest;

import java.util.List;

@Service
public interface EventsAdminService {
    List<EventFullDto> getEvents(
            List<Integer> users,
            List<Integer> categories,
            List<String> states,
            String rangeStart,
            String rangeEnd,
            Pageable pageable
    );

    EventFullDto updateEvent(
            UpdateEventAdminRequest updateEventAdminRequest,
            Integer eventId);
}
