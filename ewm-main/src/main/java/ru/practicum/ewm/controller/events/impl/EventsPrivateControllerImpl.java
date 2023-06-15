package ru.practicum.ewm.controller.events.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.controller.events.EventsPrivateController;
import ru.practicum.ewm.model.events.dto.*;
import ru.practicum.ewm.model.requests.dto.ParticipationRequestDto;
import ru.practicum.ewm.service.events.EventsPrivateService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventsPrivateControllerImpl implements EventsPrivateController {

    private final EventsPrivateService service;

    public List<EventShortDto> getEvents(Long userId, Integer from, Integer size) {
        Pageable pageable = PageRequest.of(from, size);
        return service.getEvents(userId, pageable);
    }

    public EventFullDto setEvent(NewEventDto newEventDto, Long userId) {
        return service.setEvent(newEventDto, userId);
    }


    public EventFullDto getEvent(Long userId, Long eventId) {
        return service.getEvent(userId, eventId);
    }


    public EventFullDto updateEvent(Long userId, Long eventId,
                                    UpdateEventUserRequest updateEventUserRequest) {
        return service.updateEvent(userId, eventId, updateEventUserRequest);
    }


    public List<ParticipationRequestDto> getEventRequests(Long userId, Long eventId) {
        return service.getEventRequests(userId, eventId);
    }


    public EventRequestStatusUpdateResult updateEventStatusRequest(EventRequestStatusUpdateRequest eventRequestStatusUpdateRequest,
                                                                   Long userId,
                                                                   Long eventId) {
        return service.updateEventStatusRequest(eventRequestStatusUpdateRequest, userId, eventId);
    }
}
