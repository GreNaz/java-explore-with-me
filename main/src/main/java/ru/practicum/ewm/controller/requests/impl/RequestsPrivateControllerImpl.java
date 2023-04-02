package ru.practicum.ewm.controller.requests.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.controller.requests.RequestsPrivateController;
import ru.practicum.ewm.model.requests.ParticipationRequestDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RequestsPrivateControllerImpl implements RequestsPrivateController {

    public List<ParticipationRequestDto> getRequest(
            @PathVariable Integer userId) {
        return null;
    }

    public ParticipationRequestDto setRequest(
            @RequestParam Integer eventId,
            @PathVariable Integer userId
    ) {
        return null;
    }

    public ParticipationRequestDto updateRequest(
            @PathVariable Integer userId,
            @PathVariable Integer requestId) {
        return null;
    }
}
