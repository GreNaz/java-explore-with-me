package ru.practicum.ewm.service.events.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.model.categories.Category;
import ru.practicum.ewm.model.errors.ConflictException;
import ru.practicum.ewm.model.errors.NotFoundException;
import ru.practicum.ewm.model.events.Event;
import ru.practicum.ewm.model.events.EventMapper;
import ru.practicum.ewm.model.events.dto.*;
import ru.practicum.ewm.model.requests.dto.ParticipationRequestDto;
import ru.practicum.ewm.model.users.User;
import ru.practicum.ewm.repository.categories.CategoriesRepository;
import ru.practicum.ewm.repository.events.EventsRepository;
import ru.practicum.ewm.repository.location.LocationRepository;
import ru.practicum.ewm.repository.users.UsersRepository;
import ru.practicum.ewm.service.events.EventsPrivateService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventsPrivateServiceImpl implements EventsPrivateService {

    private final EventsRepository eventsRepository;
    private final UsersRepository usersRepository;
    private final CategoriesRepository categoriesRepository;
    private final LocationRepository locationRepository;

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

        Event eventAfterMapping = EventMapper.EVENT_MAPPER.toEvent(initiator, category, newEventDto);

        Event event = eventsRepository.save(eventAfterMapping);

        return EventMapper.EVENT_MAPPER.toEventFullDto(event);
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
