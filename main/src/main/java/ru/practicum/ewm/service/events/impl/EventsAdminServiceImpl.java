package ru.practicum.ewm.service.events.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.model.events.dto.EventFullDto;
import ru.practicum.ewm.model.events.dto.UpdateEventAdminRequest;
import ru.practicum.ewm.repository.events.EventsRepository;
import ru.practicum.ewm.service.events.EventsAdminService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EventsAdminServiceImpl implements EventsAdminService {
    private final EventsRepository repository;
    @Override
    public List<EventFullDto> getEvents(List<Integer> users,
                                        List<Integer> categories,
                                        List<String> states,
                                        String rangeStart,
                                        String rangeEnd,
                                        Pageable pageable) {
        return null;
    }

    @Override
    public EventFullDto updateEvent(UpdateEventAdminRequest updateEventAdminRequest,
                                    Integer eventId) {
        return null;
    }
}
