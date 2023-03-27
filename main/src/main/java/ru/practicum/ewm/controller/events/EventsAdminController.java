package ru.practicum.ewm.controller.events;

import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.model.EventFullDto;
import ru.practicum.ewm.model.UpdateEventAdminRequest;

import java.util.List;

/**
 * API для работы с событиями
 */
@RestController("/admin/events")
public class EventsAdminController {

    /**
     * Поиск событий
     * Эндпоинт возвращает полную информацию обо всех событиях подходящих под переданные условия
     * В случае, если по заданным фильтрам не найдено ни одного события, возвращает пустой список
     *
     * @param users      список id пользователей, чьи события нужно найти
     * @param categories список id категорий в которых будет вестись поиск
     * @param states     список состояний в которых находятся искомые события
     * @param rangeStart дата и время не раньше которых должно произойти событие
     * @param rangeEnd   дата и время не позже которых должно произойти событие
     * @param from       количество событий, которые нужно пропустить для формирования текущего набора
     * @param size       количество событий в наборе
     * @return 200 - События найдены List<EventFullDto>
     * 400 - Запрос составлен некорректно ApiError
     */
    @GetMapping()
    List<EventFullDto> getEvents(
            @RequestParam(required = false) List<Integer> users,
            @RequestParam(required = false) List<Integer> categories,
            @RequestParam(required = false) List<String> states,
            @RequestParam(required = false) String rangeStart,
            @RequestParam(required = false) String rangeEnd,
            @RequestParam(defaultValue = "0") Integer from,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        return null;
    }

    /**
     * Редактирование данных события и его статуса (отклонение/публикация).
     * Редактирование данных любого события администратором. Валидация данных не требуется. Обратите внимание:
     * дата начала изменяемого события должна быть не ранее чем за час от даты публикации. (Ожидается код ошибки 409)
     * событие можно публиковать, только если оно в состоянии ожидания публикации (Ожидается код ошибки 409)
     * событие можно отклонить, только если оно еще не опубликовано (Ожидается код ошибки 409)
     *
     * @param updateEventAdminRequest Данные для изменения информации о событии
     * @param eventId                 id события
     * @return 200 - Событие отредактировано EventFullDto
     * 404 - Событие не найдено или недоступно ApiError
     * 409 - Событие не удовлетворяет правилам редактирования ApiError
     */
    @PatchMapping("{eventId}")
    EventFullDto updateEvent(
            @RequestBody UpdateEventAdminRequest updateEventAdminRequest,
            @PathVariable Integer eventId) {
        return null;
    }
}
