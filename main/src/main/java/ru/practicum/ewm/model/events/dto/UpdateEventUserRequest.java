package ru.practicum.ewm.model.events.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import ru.practicum.ewm.model.Location;
import ru.practicum.ewm.model.categories.dto.CategoryDto;
import ru.practicum.ewm.model.events.StateAction;

import java.time.LocalDateTime;

/**
 * Данные для изменения информации о событии.
 * Если поле в запросе не указано (равно null)
 * - значит изменение этих данных не треубется.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEventUserRequest {
    private String annotation; // Новая аннотация
    private CategoryDto category; // Новая категория
    private String description; //  Новое описание
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime eventDate; //  Новые дата и время на которые намечено событие. Дата и время указываются в формате "yyyy-MM-dd HH:mm:ss"
    private Location location;
    private Boolean paid; //  Новое значение флага о платности мероприятия
    private Integer participantLimit; //  Новый лимит пользователей
    private Boolean requestModeration; //  Нужна ли пре-модерация заявок на участие
    private StateAction stateAction; //  Новое состояние события SEND_TO_REVIEW, CANCEL_REVIEW
    private String title; //  Новый заголовок
}
