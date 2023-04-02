package ru.practicum.ewm.service.requests;

import org.springframework.stereotype.Service;
import ru.practicum.ewm.model.requests.dto.ParticipationRequestDto;

import java.util.List;

@Service
public interface RequestsService {
    List<ParticipationRequestDto> getRequest(Integer userId);

    ParticipationRequestDto setRequest(Integer eventId,
                                       Integer userId
    );

    ParticipationRequestDto updateRequest(Integer userId,
                                          Integer requestId);
}
