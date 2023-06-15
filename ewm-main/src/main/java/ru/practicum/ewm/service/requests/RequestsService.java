package ru.practicum.ewm.service.requests;

import ru.practicum.ewm.model.requests.dto.ParticipationRequestDto;

import javax.transaction.Transactional;
import java.util.List;

public interface RequestsService {
    List<ParticipationRequestDto> getRequest(Long userId);

    @Transactional
    ParticipationRequestDto setRequest(Long eventId, Long userId);

    @Transactional
    ParticipationRequestDto updateRequest(Long userId, Long requestId);
}
