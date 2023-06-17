package ru.practicum.ewm.model.events.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import ru.practicum.ewm.model.location.Location;
import ru.practicum.ewm.model.categories.dto.CategoryDto;
import ru.practicum.ewm.model.location.LocationDto;
import ru.practicum.ewm.model.users.dto.UserShortDto;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventFullDto {
    private Long id;
    private String annotation; //Краткое описание
    @NotNull
    private CategoryDto category;
    private Integer confirmedRequests;  //Количество одобренных заявок на участие в данном событии
    private LocalDateTime createdOn; //Дата и время создания события (в формате "yyyy-MM-dd HH:mm:ss")
    private String description; //Полное описание события
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime eventDate; //Дата и время на которые намечено событие (в формате "yyyy-MM-dd HH:mm:ss")
    private UserShortDto initiator;
    private LocationDto location;
    @NotNull
    private Boolean paid; //Нужно ли оплачивать участие
    private Integer participantLimit; //Ограничение на количество участников. Значение 0 - означает отсутствие ограничения
    private LocalDateTime publishedOn; //Дата и время публикации события (в формате "yyyy-MM-dd HH:mm:ss")
    private Boolean requestModeration; //Нужна ли пре-модерация заявок на участие
    private String state; //Список состояний жизненного цикла события
    @NotNull
    private String title; //Заголовок
    private Long views; //Количество просмотрев события
}
