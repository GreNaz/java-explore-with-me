package ru.practicum.ewm.repository.events.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.ViewStatsDTO;
import lombok.experimental.UtilityClass;
import ru.practicum.ewm.model.errors.BadRequestException;
import ru.practicum.ewm.model.events.dto.EventFullDto;
import ru.practicum.ewm.model.requests.ParticipationRequest;
import ru.practicum.ewm.repository.requests.RequestsRepository;
import ru.practicum.ewm.statistic.StatService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@UtilityClass
public class EventUtil {
    public List<EventFullDto> getViews(List<EventFullDto> eventDtos, StatService statService) {
        LocalDateTime min = eventDtos.stream()
                .map(EventFullDto::getPublishedOn)
                .min(LocalDateTime::compareTo)
                .orElseThrow(() -> new BadRequestException("Bad input events"));
        Map<String, EventFullDto> views = eventDtos.stream().collect(Collectors.toMap(fullEventDto
                -> "/events/" + fullEventDto.getId(), fullEventDto -> fullEventDto));
        Object responseBody = statService.getViewStats(
                        min,
                        LocalDateTime.now(),
                        new ArrayList<>(views.keySet()),
                        true)
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

    public void getConfirmedRequests(List<EventFullDto> eventDtos,
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
}
