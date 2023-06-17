package ru.practicum.ewm.model.events.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import ru.practicum.ewm.model.location.Location;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * Новое событие
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewEventDto {
    @NotBlank
    @Size(max = 2000, min = 20)
    private String annotation; //Краткое описание события
    @NotNull
    private Integer category; //id категории к которой относится событие
    @NotBlank
    @Size(max = 7000, min = 20)
    private String description; //Полное описание события
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime eventDate; //Дата и время на которые намечено событие. Дата и время указываются в формате "yyyy-MM-dd HH:mm:ss"
    @NotNull
    private Location location;
    @NotNull
    @Size(min = 3, max = 120)
    private String title; //Заголовок события
    private boolean paid; //Нужно ли оплачивать участие в событии
    @PositiveOrZero
    private int participantLimit = 0; //Ограничение на количество участников. Значение 0 - означает отсутствие ограничения
    private boolean requestModeration = true; //Нужна ли пре-модерация заявок на участие. Если true, то все заявки будут ожидать подтверждения инициатором события. Если false - то будут подтверждаться автоматически.
}
