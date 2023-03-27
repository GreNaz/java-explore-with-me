package ru.practicum.ewm.model.events;

import ru.practicum.ewm.model.requests.ParticipationRequestDto;

/**
 * Результат подтверждения/отклонения заявок на участие в событии
 */
public class EventRequestStatusUpdateResult {
    private ParticipationRequestDto confirmedRequests;
    private ParticipationRequestDto rejectedRequests;
}
