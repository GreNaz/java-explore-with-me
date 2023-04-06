package ru.practicum.ewm.service.events.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.model.Location;
import ru.practicum.ewm.model.categories.Category;
import ru.practicum.ewm.model.errors.ConflictException;
import ru.practicum.ewm.model.errors.NotFoundException;
import ru.practicum.ewm.model.events.Event;
import ru.practicum.ewm.model.events.State;
import ru.practicum.ewm.model.events.dto.*;
import ru.practicum.ewm.model.requests.RequestStatus;
import ru.practicum.ewm.model.requests.dto.ParticipationRequestDto;
import ru.practicum.ewm.model.users.User;
import ru.practicum.ewm.repository.categories.CategoriesRepository;
import ru.practicum.ewm.repository.events.EventsRepository;
import ru.practicum.ewm.repository.location.LocationRepository;
import ru.practicum.ewm.repository.requests.RequestsRepository;
import ru.practicum.ewm.repository.users.UsersRepository;
import ru.practicum.ewm.service.events.EventsPrivateService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

import static ru.practicum.ewm.model.events.EventMapper.EVENT_MAPPER;
import static ru.practicum.ewm.model.events.State.CANCELED;
import static ru.practicum.ewm.model.events.State.PENDING;

@Service
@RequiredArgsConstructor
public class EventsPrivateServiceImpl implements EventsPrivateService {
    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final EventsRepository eventsRepository;
    private final UsersRepository usersRepository;
    private final CategoriesRepository categoriesRepository;
    private final LocationRepository locationRepository;
    private final RequestsRepository requestsRepository;

    @Override
    public List<EventShortDto> getEvents(Integer userId, Pageable pageable) {
        return null;
    }

    @Override
    public EventFullDto setEvent(NewEventDto newEventDto, Integer userId) {
        if (newEventDto.getEventDate().isBefore(LocalDateTime.now())) {
            throw new ConflictException("Event contains wrong date");
        }

        User initiator = usersRepository.findById(userId).orElseThrow(
                () -> new NotFoundException("User with id = " + userId + " not found"));
        Category category = categoriesRepository.findById(newEventDto.getCategory()).orElseThrow(
                () -> new NotFoundException("Category with id = " + newEventDto.getCategory() + "not found"));

        newEventDto.setLocation(locationRepository.save(newEventDto.getLocation()));

        Event eventAfterMapping = EVENT_MAPPER.toEvent(initiator, category, newEventDto);

        Event event = eventsRepository.save(eventAfterMapping);

        return EVENT_MAPPER.toEventFullDto(event);
    }

    @Override
    public EventFullDto getEvent(Integer userId, Integer eventId) {
        return null;
    }

    @Override
    public EventFullDto updateEvent(Integer userId,
                                    Integer eventId,
                                    UpdateEventUserRequest updateEventUserRequest) {

        Event event = eventsRepository.findById(eventId).orElseThrow(() ->
                new NotFoundException("Event not found"));

        if (!event.getInitiator().getId().equals(userId)) {
            throw new NotFoundException("You can't update this event");
        }

        if (updateEventUserRequest.getEventDate() != null) {
            LocalDateTime time = LocalDateTime.parse(updateEventUserRequest.getEventDate().format(FORMATTER));
            if (LocalDateTime.now().isAfter(time.minusHours(2))) {
                throw new ConflictException("Event starts in less then 2 hours");
            }
        }

        if (event.getState().equals(State.PUBLISHED)) {
            throw new ConflictException("You can't update published event");
        }

        if (updateEventUserRequest.getCategory() != null
                && !Objects.equals(updateEventUserRequest.getCategory().getId(), event.getCategory().getId())) {
            Category category = categoriesRepository.findById(updateEventUserRequest.getCategory().getId()).orElseThrow(()
                    -> new NotFoundException("Category not found"));
            event.setCategory(category);
        }
        if (updateEventUserRequest.getLocation() != null) {
            Location location = locationRepository.save(updateEventUserRequest.getLocation());
            event.setLocation(location);
        }

        switch (updateEventUserRequest.getStateAction()) {
            case CANCEL_REVIEW:
                event.setState(CANCELED);
                break;
            case SEND_TO_REVIEW:
                event.setState(PENDING);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + updateEventUserRequest.getStateAction());
        }

        EVENT_MAPPER.updateEventFromDto(updateEventUserRequest, event);

        EventFullDto fullEventDto = EVENT_MAPPER.toEventFullDto(event);

        fullEventDto.setConfirmedRequests(
                requestsRepository.findAllByEventIdAndStatus(eventId, RequestStatus.CONFIRMED).size()
        );

        return fullEventDto;
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
