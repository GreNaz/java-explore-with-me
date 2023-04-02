package ru.practicum.ewm.service.requests.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.repository.requests.RequestsRepository;
import ru.practicum.ewm.service.requests.RequestsService;

@Service
@RequiredArgsConstructor
public class RequestsServiceImpl implements RequestsService {
    private final RequestsRepository repository;
}
