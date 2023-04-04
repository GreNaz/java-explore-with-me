package ru.practicum.ewm.controller.events;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.model.events.dto.*;
import ru.practicum.ewm.model.requests.dto.ParticipationRequestDto;

import javax.validation.Valid;
import java.util.List;

/**
 * Закрытый API для работы с событиями
 */
@RestController
@RequestMapping("/users/{userId}/events")
public interface EventsPrivateController {

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
    @GetMapping
    List<EventShortDto> getEvents(@PathVariable Integer userId,
                                  @RequestParam(defaultValue = "0") Integer from,
                                  @RequestParam(defaultValue = "10") Integer size
    );

    /**
     * Добавление нового события
     * дата и время на которые намечено событие не может быть раньше, чем через два часа от текущего момента
     *
     * @param newEventDto данные добавляемого события
     * @param userId      id текущего пользователя
     * @return 201 - Событие добавлено EventFullDto
     * 400 - Запрос составлен некорректно ApiError
     * 409 - Событие не удовлетворяет правилам создания ApiError
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    EventFullDto setEvent(@RequestBody @Valid NewEventDto newEventDto,
                          @PathVariable Integer userId
    );

    /**
     * Получение полной информации о событии добавленном текущим пользователем
     *
     * @param userId  id текущего пользователя
     * @param eventId id события
     * @return 200 - Событие найдено
     * 400 - Запрос составлен некорректно ApiError
     * 404 - Событие не найдено или недоступно ApiError
     */
    @GetMapping("{eventId}")
    EventFullDto getEvent(@PathVariable Integer userId,
                          @PathVariable Integer eventId);

    /**
     * @param userId                 id текущего пользователя
     * @param eventId                id события
     * @param updateEventUserRequest Новые данные события
     * @return 200 - Событие обновлено EventFullDto
     * 400 - Запрос составлен некорректно ApiError
     * 404 - Событие не найдено или недоступно ApiError
     * 409 - Событие не удовлетворяет правилам редактирования ApiError
     */
    @PatchMapping("{eventId}")
    EventFullDto updateEvent(@PathVariable Integer userId,
                             @PathVariable Integer eventId,
                             @RequestBody UpdateEventUserRequest updateEventUserRequest);

    /**
     * В случае, если по заданным фильтрам не найдено ни одной заявки, возвращает пустой список
     *
     * @param userId  id текущего пользователя
     * @param eventId id события
     * @return 200 - Найдены запросы на участие List<ParticipationRequestDto>
     * 400 - Запрос составлен некорректно ApiError
     */
    @GetMapping("{eventId}/requests")
    List<ParticipationRequestDto> getEventRequests(@PathVariable Integer userId,
                                                   @PathVariable Integer eventId);

    /**
     * Изменение статуса (подтверждена, отменена) заявок на участие в событии текущего пользователя
     * <p>
     * если для события лимит заявок равен 0 или отключена пре-модерация заявок, то подтверждение заявок не требуется
     * нельзя подтвердить заявку, если уже достигнут лимит по заявкам на данное событие (Ожидается код ошибки 409)
     * статус можно изменить только у заявок, находящихся в состоянии ожидания (Ожидается код ошибки 409)
     * если при подтверждении данной заявки, лимит заявок для события исчерпан, то все неподтверждённые заявки необходимо отклонить
     *
     * @param eventRequestStatusUpdateRequest Новый статус для заявок на участие в событии текущего пользователя
     * @param userId                          id текущего пользователя
     * @param eventId                         id события текущего пользователя
     * @return 200 - Статус заявок изменён EventRequestStatusUpdateResult
     * 400 - Запрос составлен некорректно ApiError
     * 404 - Событие не найдено или недоступно ApiError
     * 409 - Достигнут лимит одобренных заявок ApiError
     */

    @PatchMapping("{eventId}/requests")
    EventRequestStatusUpdateResult updateEventStatusRequest(@RequestBody EventRequestStatusUpdateRequest eventRequestStatusUpdateRequest,
                                                            @PathVariable Integer userId,
                                                            @PathVariable Integer eventId);
}
