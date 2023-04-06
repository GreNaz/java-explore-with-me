package ru.practicum.ewm.service.requests;

import org.springframework.stereotype.Service;
import ru.practicum.ewm.model.requests.dto.ParticipationRequestDto;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface RequestsService {
    List<ParticipationRequestDto> getRequest(Integer userId);

    @Transactional
    ParticipationRequestDto setRequest(Integer eventId, Integer userId);

    @Transactional
    ParticipationRequestDto updateRequest(Integer userId, Integer requestId);
}
