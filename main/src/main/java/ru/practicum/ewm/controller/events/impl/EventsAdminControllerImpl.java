package ru.practicum.ewm.controller.events.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.controller.events.EventsAdminController;
import ru.practicum.ewm.model.events.dto.EventFullDto;
import ru.practicum.ewm.model.events.dto.UpdateEventAdminRequest;
import ru.practicum.ewm.service.events.EventService;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class EventsAdminControllerImpl implements EventsAdminController {

    private final EventService service;

    public List<EventFullDto> getEvents(
            List<Integer> users,
            List<Integer> categories,
            List<String> states,
            String rangeStart,
            String rangeEnd,
            Integer from,
            Integer size
    ) {
        return null;
    }

    public EventFullDto updateEvent(
            UpdateEventAdminRequest updateEventAdminRequest,
            Integer eventId) {
        return null;
    }
}
