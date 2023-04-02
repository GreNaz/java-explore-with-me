package ru.practicum.ewm.service.events;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.model.events.dto.EventFullDto;
import ru.practicum.ewm.model.events.dto.EventShortDto;

import java.util.List;

@Service
public interface EventService {
    List<EventShortDto> getEvents(String text,
                                  List<Integer> categories,
                                  Boolean paid,
                                  String rangeStart,
                                  String rangeEnd,
                                  String sort,
                                  Boolean onlyAvailable,
                                  Pageable pageable
    );

    EventFullDto getEvent(Integer eventId);

}
