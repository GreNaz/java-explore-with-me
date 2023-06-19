package ru.practicum.ewm.controller.events.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.controller.events.EventsAdminController;
import ru.practicum.ewm.model.events.State;
import ru.practicum.ewm.model.events.dto.EventFullDto;
import ru.practicum.ewm.model.events.dto.UpdateEventAdminRequest;
import ru.practicum.ewm.service.events.EventsAdminService;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
public class EventsAdminControllerImpl implements EventsAdminController {

    private final EventsAdminService service;

    public List<EventFullDto> getEvents(List<Integer> users,
                                        List<Integer> categories,
                                        List<State> states,
                                        String rangeStart,
                                        String rangeEnd,
                                        Integer from,
                                        Integer size) {
        return service.getEvents(users, categories, states, rangeStart, rangeEnd, from, size);
    }

    public EventFullDto updateEvent(UpdateEventAdminRequest updateEventAdminRequest, Long eventId) {
        return service.updateEvent(updateEventAdminRequest, eventId);
    }
}
