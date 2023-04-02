package ru.practicum.ewm.model.events.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.practicum.ewm.model.Location;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

/**
 * Новое событие
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class NewEventDto {
    @NotNull
    @Max(2000)
    @Min(20)
    private String annotation; //Краткое описание события
    @NotNull
    private Integer category; //id категории к которой относится событие
    @NotNull
    @Max(7000)
    @Min(20)
    private String description; //Полное описание события
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime eventDate; //Дата и время на которые намечено событие. Дата и время указываются в формате "yyyy-MM-dd HH:mm:ss"
    @NotNull
    private Location location;
    @NotNull
    @Max(120)
    @Min(3)
    private String title; //Заголовок события


    private Boolean paid; //Нужно ли оплачивать участие в событии
    @PositiveOrZero
    private Integer participantLimit; //Ограничение на количество участников. Значение 0 - означает отсутствие ограничения
    private Boolean requestModeration; //Нужна ли пре-модерация заявок на участие. Если true, то все заявки будут ожидать подтверждения инициатором события. Если false - то будут подтверждаться автоматически.

}
