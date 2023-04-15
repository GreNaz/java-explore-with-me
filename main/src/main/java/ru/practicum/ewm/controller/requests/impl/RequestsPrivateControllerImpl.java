package ru.practicum.ewm.controller.requests.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.controller.requests.RequestsPrivateController;
import ru.practicum.ewm.model.requests.dto.ParticipationRequestDto;
import ru.practicum.ewm.service.requests.RequestsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RequestsPrivateControllerImpl implements RequestsPrivateController {
    private final RequestsService requestsService;

    public List<ParticipationRequestDto> getRequest(Integer userId) {
        return requestsService.getRequest(userId);
    }

    public ParticipationRequestDto setRequest(Integer eventId,
                                              Integer userId) {
        return requestsService.setRequest(eventId, userId);
    }

    public ParticipationRequestDto updateRequest(Integer userId,
                                                 Integer requestId) {
        return requestsService.updateRequest(userId, requestId);
    }
}
