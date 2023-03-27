package ru.practicum.ewm.controller.events;

import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.model.EventFullDto;
import ru.practicum.ewm.model.EventShortDto;
import ru.practicum.ewm.model.NewEventDto;

import java.util.List;

/**
 * Закрытый API для работы с событиями
 */
@RestController("/users/{userId}/events")
public class EventsPrivateController {
    /**
     * Получение событий, добавленных текущим пользователем
     * В случае, если по заданным фильтрам не найдено ни одного события, возвращает пустой список
     *
     * @param userId id текущего пользователя
     * @param from   количество элементов, которые нужно пропустить для формирования текущего набора
     * @param size   количество элементов в наборе
     * @return 200 - События найдены List<EventShortDto>
     * 400 - Запрос составлен некорректно ApiError
     */
    @GetMapping()
    List<EventShortDto> getEvents(
            @PathVariable Integer userId,
            @RequestParam(defaultValue = "0") Integer from,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        return null;
    }

    /**
     * Добавление нового события
     * Обратите внимание: дата и время на которые намечено событие не может быть раньше, чем через два часа от текущего момента
     * @param newEventDto данные добавляемого события
     * @param userId id текущего пользователя
     * @return 201 - Событие добавлено EventFullDto
     * 400 - Запрос составлен некорректно ApiError
     * 409 - Событие не удовлетворяет правилам создания ApiError
     */
    @PostMapping()
    EventFullDto setEvent(
            @RequestBody NewEventDto newEventDto,
            @PathVariable Integer userId
    ) {
        return null;
    }
}
