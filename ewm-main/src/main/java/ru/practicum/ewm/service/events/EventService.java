package ru.practicum.ewm.service.events;

import org.springframework.data.domain.Pageable;
import ru.practicum.ewm.model.events.dto.EventFullDto;
import ru.practicum.ewm.model.events.dto.EventShortDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface EventService {
    List<EventShortDto> getEvents(String text,
                                  List<Integer> categories,
                                  Boolean paid,
                                  String rangeStart,
                                  String rangeEnd,
                                  String sort,
                                  Boolean onlyAvailable,
                                  Pageable pageable,
                                  HttpServletRequest request);

    EventFullDto getEvent(Long eventId, HttpServletRequest request);

}
