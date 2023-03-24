package ru.practicum.ewm.model;

import java.time.LocalDateTime;

//Данные для изменения информации о событии. Если поле в запросе не указано (равно null) - значит изменение этих данных не треубется.
public class UpdateEventAdminRequest {
    private String annotation; // Новая аннотация
    private CategoryDto category; // Новая категория
    private String description; //  Новое описание
    private LocalDateTime eventDate; //  Новые дата и время на которые намечено событие. Дата и время указываются в формате "yyyy-MM-dd HH:mm:ss"
    private Location location;
    private Boolean paid; //  Новое значение флага о платности мероприятия
    private Integer participantLimit; //  Новый лимит пользователей
    private Boolean requestModeration; //  Нужна ли пре-модерация заявок на участие
    private String stateAction; //  Новое состояние события PUBLISH_EVENT, REJECT_EVENT
    private String title; //  Новый заголовок
}
