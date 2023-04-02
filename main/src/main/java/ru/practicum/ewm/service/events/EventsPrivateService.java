package ru.practicum.ewm.service.events;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.model.events.dto.*;
import ru.practicum.ewm.model.requests.dto.ParticipationRequestDto;

import java.util.List;

@Service
public interface EventsPrivateService {

    List<EventShortDto> getEvents(Integer userId,
                                  Pageable pageable);


    EventFullDto setEvent(NewEventDto newEventDto,
                          Integer userId);


    EventFullDto getEvent(Integer userId,
                          Integer eventId);


    EventFullDto updateEvent(Integer userId,
                             Integer eventId,
                             UpdateEventUserRequest updateEventUserRequest);


    List<ParticipationRequestDto> getEventRequests(Integer userId,
                                                   Integer eventId);


    EventRequestStatusUpdateResult updateEventStatusRequest(
            EventRequestStatusUpdateRequest eventRequestStatusUpdateRequest,
            Integer userId,
            Integer eventId);
}
