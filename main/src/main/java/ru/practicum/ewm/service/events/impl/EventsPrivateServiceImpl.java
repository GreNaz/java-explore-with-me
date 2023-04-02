package ru.practicum.ewm.service.events.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.model.events.dto.*;
import ru.practicum.ewm.model.requests.dto.ParticipationRequestDto;
import ru.practicum.ewm.repository.events.EventsRepository;
import ru.practicum.ewm.service.events.EventsPrivateService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventsPrivateServiceImpl implements EventsPrivateService {

    private final EventsRepository repository;

    @Override
    public List<EventShortDto> getEvents(Integer userId, Pageable pageable) {
        return null;
    }

    @Override
    public EventFullDto setEvent(NewEventDto newEventDto, Integer userId) {
        return null;
    }

    @Override
    public EventFullDto getEvent(Integer userId, Integer eventId) {
        return null;
    }

    @Override
    public EventFullDto updateEvent(Integer userId,
                                    Integer eventId,
                                    UpdateEventUserRequest updateEventUserRequest) {
        return null;
    }

    @Override
    public List<ParticipationRequestDto> getEventRequests(Integer userId, Integer eventId) {
        return null;
    }

    @Override
    public EventRequestStatusUpdateResult updateEventStatusRequest(EventRequestStatusUpdateRequest eventRequestStatusUpdateRequest,
                                                                   Integer userId,
                                                                   Integer eventId) {
        return null;
    }
}
