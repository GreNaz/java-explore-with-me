package ru.practicum.ewm.service.requests.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.model.errors.ConflictException;
import ru.practicum.ewm.model.errors.NotFoundException;
import ru.practicum.ewm.model.events.Event;
import ru.practicum.ewm.model.events.State;
import ru.practicum.ewm.model.requests.ParticipationRequest;
import ru.practicum.ewm.model.requests.RequestStatus;
import ru.practicum.ewm.model.requests.RequestsMapper;
import ru.practicum.ewm.model.requests.dto.ParticipationRequestDto;
import ru.practicum.ewm.model.users.User;
import ru.practicum.ewm.repository.events.EventsRepository;
import ru.practicum.ewm.repository.requests.RequestsRepository;
import ru.practicum.ewm.repository.users.UsersRepository;
import ru.practicum.ewm.service.requests.RequestsService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequestsServiceImpl implements RequestsService {

    private final RequestsRepository requestsRepository;
    private final EventsRepository eventsRepository;
    private final UsersRepository usersRepository;

    @Override
    public List<ParticipationRequestDto> getRequest(Integer userId) {
        return null;
    }

    @Override
    public ParticipationRequestDto setRequest(Integer eventId, Integer userId) {

        Event event = eventsRepository.findById(eventId).orElseThrow(() -> new NotFoundException("Event not found"));
        if (Objects.equals(event.getInitiator().getId(), userId)) {
            throw new ConflictException("You can't send request to your own event");
        }
        if (event.getState() != State.PUBLISHED) {
            throw new ConflictException("Event is not published");
        }
        int confirmedRequests = requestsRepository.findByEventIdConfirmed(eventId).size();
        if (event.getParticipantLimit() != 0 && event.getParticipantLimit() <= confirmedRequests) {
            throw new ConflictException("Participant limit reached");
        }
        User user = usersRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
        RequestStatus status = RequestStatus.PENDING;
        if (Boolean.TRUE.equals(!event.getRequestModeration()) || event.getParticipantLimit() == 0) {
            status = RequestStatus.CONFIRMED;
        }
        ParticipationRequest participationRequest = ParticipationRequest.builder()
                .created(LocalDateTime.now())
                .status(status)
                .event(event)
                .requester(user)
                .build();

        Optional<ParticipationRequest> check = requestsRepository.findByEventIdAndRequesterId(eventId, userId);
        if (check.isPresent()) throw new ConflictException("You already have request to event");

        participationRequest = requestsRepository.save(participationRequest);
        return RequestsMapper.REQUESTS_MAPPER.toParticipationRequestDto(participationRequest);
    }

    @Override
    public ParticipationRequestDto updateRequest(Integer userId, Integer requestId) {
        return null;
    }
}
