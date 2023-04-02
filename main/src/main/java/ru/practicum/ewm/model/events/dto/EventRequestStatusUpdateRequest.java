package ru.practicum.ewm.model.events.dto;

import java.util.List;

/**
 * Изменение статуса запроса на участие в событии текущего пользователя
 */
public class EventRequestStatusUpdateRequest {
    private List<Integer> requestIds; //Идентификаторы запросов на участие в событии текущего пользователя
    private String status; //Новый статус запроса на участие в событии текущего пользователя
}
