package ru.practicum.ewm.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EventShortDto {
    private Integer id;
    @NotBlank
    private String annotation; //Краткое описание
    @NotNull
    private CategoryDto category; //Категория
    private Integer confirmedRequests; //Количество одобренных заявок на участие в данном событии
    private String eventDate; //Дата и время на которые намечено событие (в формате "yyyy-MM-dd HH:mm:ss")
    private UserShortDto initiator; //Дата и время на которые намечено событие (в формате "yyyy-MM-dd HH:mm:ss")
    @NotNull
    private Boolean paid; //Нужно ли оплачивать участие
    private String title; //Заголовок
    private Integer views; //Количество просмотрев события
}
