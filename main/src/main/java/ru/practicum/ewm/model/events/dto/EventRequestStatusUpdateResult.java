package ru.practicum.ewm.model.events.dto;

import lombok.*;
import ru.practicum.ewm.model.requests.dto.ParticipationRequestDto;

/**
 * Результат подтверждения/отклонения заявок на участие в событии
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventRequestStatusUpdateResult {
    private ParticipationRequestDto confirmedRequests;
    private ParticipationRequestDto rejectedRequests;
}
