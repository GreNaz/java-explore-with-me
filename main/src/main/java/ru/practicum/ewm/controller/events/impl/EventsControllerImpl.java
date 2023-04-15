package ru.practicum.ewm.controller.events.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.controller.events.EventsController;
import ru.practicum.ewm.model.events.dto.EventFullDto;
import ru.practicum.ewm.model.events.dto.EventShortDto;
import ru.practicum.ewm.service.events.EventService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventsControllerImpl implements EventsController {
    private final EventService service;

    public List<EventShortDto> getEvents(String text,
                                         List<Integer> categories,
                                         Boolean paid,
                                         String rangeStart,
                                         String rangeEnd,
                                         String sort,
                                         Boolean onlyAvailable,
                                         Integer from,
                                         Integer size,
                                         HttpServletRequest request
    ) {
        Pageable pageable = PageRequest.of(from, size);
        return service.getEvents(text, categories, paid, rangeStart, rangeEnd, sort, onlyAvailable, pageable, request);
    }

    public EventFullDto getEvent(Integer eventId) {
        return service.getEvent(eventId);
    }
}
