package ru.practicum.ewm.service.events;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.ewm.model.events.dto.*;
import ru.practicum.ewm.model.requests.dto.ParticipationRequestDto;

import java.util.List;

public interface EventsPrivateService {

    List<EventShortDto> getEvents(Long userId,
                                  Pageable pageable);

    @Transactional
    EventFullDto setEvent(NewEventDto newEventDto,
                          Long userId);


    EventFullDto getEvent(Long userId,
                          Long eventId);

    @Transactional
    EventFullDto updateEvent(Long userId,
                             Long eventId,
                             UpdateEventUserRequest updateEventUserRequest);


    List<ParticipationRequestDto> getEventRequests(Long userId,
                                                   Long eventId);

    @Transactional
    EventRequestStatusUpdateResult updateEventStatusRequest(
            EventRequestStatusUpdateRequest eventRequestStatusUpdateRequest,
            Long userId,
            Long eventId);
}
