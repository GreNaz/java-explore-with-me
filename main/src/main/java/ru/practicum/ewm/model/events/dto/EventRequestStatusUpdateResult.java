package ru.practicum.ewm.model.events.dto;

import lombok.*;
import ru.practicum.ewm.model.requests.dto.ParticipationRequestDto;

import java.util.List;

/**
 * Результат подтверждения/отклонения заявок на участие в событии
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventRequestStatusUpdateResult {
    private List<ParticipationRequestDto> confirmedRequests;
    private List<ParticipationRequestDto> rejectedRequests;
}
