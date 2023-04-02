package ru.practicum.ewm.controller.events.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.controller.events.EventsController;
import ru.practicum.ewm.model.events.dto.EventFullDto;
import ru.practicum.ewm.model.events.dto.EventShortDto;
import ru.practicum.ewm.service.events.EventService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventsControllerImpl implements EventsController {
    private final EventService service;

    public List<EventShortDto> getEvents(
            String text,
            List<Integer> categories,
            Boolean paid,
            String rangeStart,
            String rangeEnd,
            String sort,
            Boolean onlyAvailable,
            Integer from,
            Integer size
    ) {
        return null;
    }

    public EventFullDto getEvent(
            Integer eventId) {
        return null;
    }
}
