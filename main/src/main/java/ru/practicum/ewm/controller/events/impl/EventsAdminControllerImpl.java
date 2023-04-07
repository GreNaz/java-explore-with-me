package ru.practicum.ewm.controller.events.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.controller.events.EventsAdminController;
import ru.practicum.ewm.model.events.dto.EventFullDto;
import ru.practicum.ewm.model.events.dto.UpdateEventAdminRequest;
import ru.practicum.ewm.service.events.EventsAdminService;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class EventsAdminControllerImpl implements EventsAdminController {

    private final EventsAdminService service;

    public List<EventFullDto> getEvents(List<Integer> users,
                                        List<Integer> categories,
                                        List<String> states,
                                        String rangeStart,
                                        String rangeEnd,
                                        Integer from,
                                        Integer size
    ) {
        Pageable pageable = PageRequest.of(from, size);
        return service.getEvents(users, categories, states, rangeStart, rangeEnd, pageable);
    }

    public EventFullDto updateEvent(UpdateEventAdminRequest updateEventAdminRequest,
                                    Integer eventId) {
        return service.updateEvent(updateEventAdminRequest, eventId);
    }
}
