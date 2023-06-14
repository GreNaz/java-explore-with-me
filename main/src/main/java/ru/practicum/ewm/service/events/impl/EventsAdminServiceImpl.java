package ru.practicum.ewm.service.events.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.model.categories.Category;
import ru.practicum.ewm.model.errors.BadRequestException;
import ru.practicum.ewm.model.errors.ConflictException;
import ru.practicum.ewm.model.errors.NotFoundException;
import ru.practicum.ewm.model.events.Event;
import ru.practicum.ewm.model.events.EventMapper;
import ru.practicum.ewm.model.events.State;
import ru.practicum.ewm.model.events.dto.EventFullDto;
import ru.practicum.ewm.model.events.dto.UpdateEventAdminRequest;
import ru.practicum.ewm.repository.categories.CategoriesRepository;
import ru.practicum.ewm.repository.events.EventsDao;
import ru.practicum.ewm.repository.events.EventsRepository;
import ru.practicum.ewm.repository.events.util.EventUtil;
import ru.practicum.ewm.repository.location.LocationRepository;
import ru.practicum.ewm.repository.requests.RequestsRepository;
import ru.practicum.ewm.service.events.EventsAdminService;
import ru.practicum.ewm.statistic.StatService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static ru.practicum.ewm.model.events.AdminStateAction.PUBLISH_EVENT;
import static ru.practicum.ewm.model.events.AdminStateAction.REJECT_EVENT;
import static ru.practicum.ewm.model.events.State.CANCELED;
import static ru.practicum.ewm.model.events.State.PUBLISHED;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventsAdminServiceImpl implements EventsAdminService {

    private final EventsRepository eventsRepository;
    private final RequestsRepository requestsRepository;
    private final CategoriesRepository categoriesRepository;
    private final LocationRepository locationRepository;

    private final EventsDao eventsDao;

    private final StatService statService;

    @Override
    public List<EventFullDto> getEvents(List<Integer> users,
                                        List<Integer> categories,
                                        List<State> states,
                                        String rangeStart,
                                        String rangeEnd,
                                        Integer from,
                                        Integer size) {
        List<EventFullDto> fullEventDtoList = eventsDao.findEvents(users, states, categories, rangeStart, rangeEnd, from, size)
                .stream()
                .map(EventMapper.EVENT_MAPPER::toEventFullDto)
                .collect(Collectors.toList());

        EventUtil.getConfirmedRequests(fullEventDtoList, requestsRepository);

        return EventUtil.getViews(fullEventDtoList, statService);
    }

    @Override
    public EventFullDto updateEvent(UpdateEventAdminRequest updateEventAdminRequest,
                                    Long eventId) {

        Event event = eventsRepository.findById(eventId).orElseThrow(()
                -> new NotFoundException("Event not found"));

        if (updateEventAdminRequest.getEventDate() != null
                && (updateEventAdminRequest.getEventDate())
                .isBefore(LocalDateTime.now())) {
            throw new BadRequestException("Date in the past");

        }
        if (updateEventAdminRequest.getStateAction() != null) {
            switch (event.getState()) {
                case PUBLISHED:
                    if (updateEventAdminRequest.getStateAction().equals(PUBLISH_EVENT)) {
                        throw new ConflictException("Event is already published");
                    }
                    if (updateEventAdminRequest.getStateAction().equals(REJECT_EVENT)) {
                        throw new ConflictException("Event is published. You can't reject it");
                    }
                    break;
                case CANCELED:
                    if (updateEventAdminRequest.getStateAction().equals(PUBLISH_EVENT)) {
                        throw new ConflictException("Event is canceled");
                    }
                    break;
                case PENDING:
                    if (updateEventAdminRequest.getStateAction().equals(PUBLISH_EVENT)) {
                        event.setState(PUBLISHED);
                    }
                    if (updateEventAdminRequest.getStateAction().equals(REJECT_EVENT)) {
                        event.setState(CANCELED);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + updateEventAdminRequest.getStateAction());
            }
        }

        if (updateEventAdminRequest.getCategory() != null) {
            Category category = categoriesRepository.findById(updateEventAdminRequest
                    .getCategory()).orElseThrow(()
                    -> new NotFoundException("Category not found for update"));
            event.setCategory(category);
        }
        EventMapper.EVENT_MAPPER.updateEventFromDto(updateEventAdminRequest, event);

        if (updateEventAdminRequest.getLocation() != null) {
            event.setLocation(locationRepository.save(updateEventAdminRequest.getLocation()));
        }

        return EventMapper.EVENT_MAPPER.toEventFullDto(eventsRepository.save(event));
    }
}
