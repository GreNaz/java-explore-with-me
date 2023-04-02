package ru.practicum.ewm.controller.events.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.controller.events.EventsPrivateController;
import ru.practicum.ewm.model.events.dto.*;
import ru.practicum.ewm.model.requests.dto.ParticipationRequestDto;
import ru.practicum.ewm.service.events.EventService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventsPrivateControllerImpl implements EventsPrivateController {

    private final EventService service;

    public List<EventShortDto> getEvents(Integer userId, Integer from, Integer size) {
        return null;
    }


    public EventFullDto setEvent(NewEventDto newEventDto, Integer userId) {
        return null;
    }


    public EventFullDto getEvent(Integer userId, Integer eventId) {
        return null;
    }


    public EventFullDto updateEvent(Integer userId, Integer eventId, UpdateEventUserRequest updateEventUserRequest) {
        return null;
    }


    public List<ParticipationRequestDto> getEventRequests(Integer userId, Integer eventId) {
        return null;
    }


    public EventRequestStatusUpdateResult updateEventStatusRequest(
            EventRequestStatusUpdateRequest eventRequestStatusUpdateRequest,
            Integer userId,
            Integer eventId) {
        return null;
    }
}
