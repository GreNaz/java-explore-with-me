package ru.practicum.ewm.model.events.dto;

import ru.practicum.ewm.model.Location;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Новое событие
 */
public class NewEventDto {
    private String annotation; //Краткое описание события
    @NotNull
    private Integer category; //id категории к которой относится событие
    @NotNull
    private String description; //Полное описание события
    @NotNull
    private LocalDateTime eventDate; //Дата и время на которые намечено событие. Дата и время указываются в формате "yyyy-MM-dd HH:mm:ss"
    @NotNull
    private Location location; //Полное описание события
    private Boolean paid; //Нужно ли оплачивать участие в событии
    private Integer participantLimit; //Ограничение на количество участников. Значение 0 - означает отсутствие ограничения
    private Boolean requestModeration; //Нужна ли пре-модерация заявок на участие. Если true, то все заявки будут ожидать подтверждения инициатором события. Если false - то будут подтверждаться автоматически.
    private String title; //Заголовок события
}
