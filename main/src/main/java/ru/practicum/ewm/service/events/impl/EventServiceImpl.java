package ru.practicum.ewm.service.events.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.repository.events.EventsRepository;
import ru.practicum.ewm.service.events.EventService;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventsRepository repository;
}
