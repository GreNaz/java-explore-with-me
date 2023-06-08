package ru.practicum.ewm.repository.events.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.ViewStatsDTO;
import ru.practicum.ewm.model.events.dto.EventFullDto;
import ru.practicum.ewm.model.events.dto.EventShortDto;
import ru.practicum.ewm.model.requests.ParticipationRequest;
import ru.practicum.ewm.repository.requests.RequestsRepository;
import ru.practicum.ewm.statistic.StatService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EventUtil {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final LocalDateTime MAX_TIME = toTime("5000-01-01 00:00:00");
    public static final LocalDateTime MIN_TIME = toTime("2000-01-01 00:00:00");

    public static List<EventFullDto> getViews(List<EventFullDto> eventDtos, StatService statService) {
        Map<String, EventFullDto> views = eventDtos.stream().collect(Collectors.toMap(fullEventDto
                -> "/events/" + fullEventDto.getId(), fullEventDto -> fullEventDto));
        Object responseBody = statService.getViewStats(
                        MIN_TIME,
                        MAX_TIME,
                        new ArrayList<>(views.keySet()),
                        false)
                .getBody();
        List<ViewStatsDTO> viewStatsDtos = new ObjectMapper().convertValue(responseBody, new TypeReference<>() {
        });
        viewStatsDtos.forEach(viewStatsDto -> {
            if (views.containsKey(viewStatsDto.getUri())) {
                views.get(viewStatsDto.getUri()).setViews(viewStatsDto.getHits());
            }
        });
        return new ArrayList<>(views.values());
    }

    public static List<EventShortDto> getViewsToShort(List<EventShortDto> eventDtos, StatService statService) {
        Map<String, EventShortDto> views = eventDtos.stream().collect(Collectors.toMap(fullEventDto -> "/events/" + fullEventDto.getId(), fullEventDto -> fullEventDto));
        Object responseBody = statService.getViewStats(MIN_TIME, MAX_TIME, new ArrayList<>(views.keySet()), false).getBody();
        List<ViewStatsDTO> viewStatsDtos = new ObjectMapper().convertValue(responseBody, new TypeReference<>() {
        });
        viewStatsDtos.forEach(viewStatsDto -> {
            if (views.containsKey(viewStatsDto.getUri())) {
                views.get(viewStatsDto.getUri()).setViews(viewStatsDto.getHits());
            }
        });
        return new ArrayList<>(views.values());
    }

    public static void getConfirmedRequests(List<EventFullDto> eventDtos,
                                            RequestsRepository requestsRepository) {
        List<Long> ids = eventDtos.stream().map(EventFullDto::getId).collect(Collectors.toList());
        List<ParticipationRequest> requests = requestsRepository.findConfirmedToListEvents(ids);

        Map<Long, Integer> counter = new HashMap<>();
        if (!requests.isEmpty()) {
            requests.forEach(request -> counter.put(request.getEvent().getId(),
                    counter.getOrDefault(request.getEvent().getId(), 0) + 1));

            eventDtos.forEach(event -> event.setConfirmedRequests(counter.get(event.getId())));
        } else {
            eventDtos.forEach(event -> event.setConfirmedRequests(0));
        }
    }

    public static void getConfirmedRequestsToShort(List<EventShortDto> eventDtos,
                                                   RequestsRepository requestsRepository) {
        List<Long> ids = eventDtos.stream().map(EventShortDto::getId).collect(Collectors.toList());
        List<ParticipationRequest> requests = requestsRepository.findConfirmedToListEvents(ids);
        Map<Long, Integer> counter = new HashMap<>();
        requests.forEach(element -> counter.put(element.getEvent().getId(),
                counter.getOrDefault(element.getEvent().getId(), 0) + 1));
        eventDtos.forEach(event -> event.setConfirmedRequests(counter.get(event.getId())));
    }

    public static String toString(LocalDateTime localDateTime) {
        return localDateTime.format(FORMATTER);
    }

    public static LocalDateTime toTime(String timeString) throws DateTimeParseException {
        return LocalDateTime.parse(timeString, FORMATTER);
    }
}
