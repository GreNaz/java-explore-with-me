package ru.practicum.ewm.model.events.dto;

import ru.practicum.ewm.model.requests.dto.ParticipationRequestDto;

/**
 * Результат подтверждения/отклонения заявок на участие в событии
 */
public class EventRequestStatusUpdateResult {
    private ParticipationRequestDto confirmedRequests;
    private ParticipationRequestDto rejectedRequests;
}
