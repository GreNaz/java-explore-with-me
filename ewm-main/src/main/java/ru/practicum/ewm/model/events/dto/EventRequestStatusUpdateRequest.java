package ru.practicum.ewm.model.events.dto;

import lombok.*;
import ru.practicum.ewm.model.requests.RequestStatus;

import java.util.List;

/**
 * Изменение статуса запроса на участие в событии текущего пользователя
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventRequestStatusUpdateRequest {
    private List<Long> requestIds; //Идентификаторы запросов на участие в событии текущего пользователя
    private RequestStatus status; //Новый статус запроса на участие в событии текущего пользователя
}
