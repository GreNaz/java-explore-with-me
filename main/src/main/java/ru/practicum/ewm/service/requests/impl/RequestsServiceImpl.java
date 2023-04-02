package ru.practicum.ewm.service.requests.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.model.requests.dto.ParticipationRequestDto;
import ru.practicum.ewm.repository.requests.RequestsRepository;
import ru.practicum.ewm.service.requests.RequestsService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestsServiceImpl implements RequestsService {
    private final RequestsRepository repository;

    @Override
    public List<ParticipationRequestDto> getRequest(Integer userId) {
        return null;
    }

    @Override
    public ParticipationRequestDto setRequest(Integer eventId, Integer userId) {
        return null;
    }

    @Override
    public ParticipationRequestDto updateRequest(Integer userId, Integer requestId) {
        return null;
    }
}
