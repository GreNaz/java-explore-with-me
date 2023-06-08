package ru.practicum.ewm.service.events.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.model.errors.BadRequestException;
import ru.practicum.ewm.model.errors.NotFoundException;
import ru.practicum.ewm.model.events.Event;
import ru.practicum.ewm.model.events.EventMapper;
import ru.practicum.ewm.model.events.State;
import ru.practicum.ewm.model.events.dto.EventFullDto;
import ru.practicum.ewm.model.events.dto.EventShortDto;
import ru.practicum.ewm.model.requests.RequestStatus;
import ru.practicum.ewm.repository.events.EventsRepository;
import ru.practicum.ewm.repository.requests.RequestsRepository;
import ru.practicum.ewm.service.categories.CategoriesService;
import ru.practicum.ewm.service.events.EventService;
import ru.practicum.ewm.statistic.HitMapper;
import ru.practicum.ewm.statistic.StatService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final LocalDateTime MAX_TIME = LocalDateTime.MAX;
    private static final LocalDateTime MIN_TIME = LocalDateTime.MIN;

    private final EventsRepository eventsRepository;
    private final RequestsRepository requestsRepository;
    private final StatService statService;
    private final CategoriesService categoriesService;

    @Override
    public List<EventShortDto> getEvents(String text,
                                         List<Integer> categories,
                                         Boolean paid,
                                         String rangeStart,
                                         String rangeEnd,
                                         String sort,
                                         Boolean onlyAvailable,
                                         Pageable pageable,
                                         HttpServletRequest request) {
        if (!categories.isEmpty()
                && categories.stream().sorted().collect(Collectors.toList()).get(0) <= 0) {
            throw new BadRequestException("bad category Id");
        }
        LocalDateTime start = null;
        LocalDateTime end = null;
        if (rangeStart != null) {
            start = LocalDateTime.parse(rangeStart, FORMATTER);
        }
        if (rangeEnd != null) {
            end = LocalDateTime.parse(rangeEnd, FORMATTER);
        }
        if (text == null) text = "";
        List<Event> events = eventsRepository.findByParamsOrderByDate(
                text.toLowerCase(),
                List.of(State.PUBLISHED),
                categories,
                paid,
                start,
                end,
                pageable);
        List<EventFullDto> fullEventDtoList = events.stream()
                .map(EventMapper.EVENT_MAPPER::toEventFullDto)
                .collect(Collectors.toList());
        fullEventDtoList.forEach(event -> event.setConfirmedRequests(requestsRepository.findByEventIdConfirmed(event.getId()).size()));
        if (Boolean.TRUE.equals(onlyAvailable)) {
            fullEventDtoList = fullEventDtoList.stream()
                    .filter(event -> event.getParticipantLimit() <= event.getConfirmedRequests())
                    .collect(Collectors.toList());
        }

        statService.createView(HitMapper.toEndpointHit("ewm-main-service", request));
        List<EventShortDto> eventsShort = fullEventDtoList.stream()
                .map(EventMapper.EVENT_MAPPER::toEventShortDto)
                .collect(Collectors.toList());
        if (sort != null && sort.equalsIgnoreCase("VIEWS")) {
            eventsShort.sort((e1, e2) -> e2.getViews().compareTo(e1.getViews()));
        }
        return eventsShort;
    }

    @Override
    public EventFullDto getEvent(Long eventId,
                                 HttpServletRequest request) {
        Event event = eventsRepository.findById(eventId).orElseThrow(() ->
                new NotFoundException("Event not found")
        );
        if (!event.getState().name().equalsIgnoreCase("published")) {
            throw new NotFoundException("Event not found");
        }
        EventFullDto fullEventDto = EventMapper.EVENT_MAPPER.toEventFullDto(event);

        fullEventDto.setConfirmedRequests(requestsRepository.findAllByEventIdAndStatus(event.getId(),
                RequestStatus.CONFIRMED).size());
        statService.createView(HitMapper.toEndpointHit("ewm-main-service", request));
        return fullEventDto;
    }
}
