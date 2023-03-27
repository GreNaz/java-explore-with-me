package ru.practicum.ewm.model.requests;

import java.time.LocalDateTime;

public class ParticipationRequestDto {
    private Integer id; // Идентификатор заявки
    private LocalDateTime created; // Дата и время создания заявки
    private Integer event; // Идентификатор события
    private Integer requester; // Идентификатор пользователя, отправившего заявку
    private String status; // Статус заявки
}
