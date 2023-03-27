package ru.practicum.ewm.model;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class EventFullDto {
    private Integer id;
    private String annotation; //Краткое описание
    @NotNull
    private CategoryDto category;
    private Integer confirmedRequests;  //Количество одобренных заявок на участие в данном событии
    private LocalDateTime createdOn; //Дата и время создания события (в формате "yyyy-MM-dd HH:mm:ss")
    private String description; //Полное описание события
    @NotNull
    private LocalDateTime eventDate; //Дата и время на которые намечено событие (в формате "yyyy-MM-dd HH:mm:ss")
    private UserShortDto initiator;
    private Location location;
    @NotNull
    private Boolean paid; //Нужно ли оплачивать участие
    private Integer participantLimit; //Ограничение на количество участников. Значение 0 - означает отсутствие ограничения
    private LocalDateTime publishedOn; //Дата и время публикации события (в формате "yyyy-MM-dd HH:mm:ss")
    private Boolean requestModeration; //Нужна ли пре-модерация заявок на участие
    private String state; //Список состояний жизненного цикла события
    @NotNull
    private String title; //Заголовок
    private Integer views; //Количество просмотрев события
}