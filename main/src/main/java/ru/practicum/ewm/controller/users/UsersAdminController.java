package ru.practicum.ewm.controller.users;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.model.users.NewUserRequest;
import ru.practicum.ewm.model.users.UserDto;

import java.util.List;

/**
 * API для работы с пользователями
 */

@Validated
@RestController
@RequestMapping("/admin/users")
public interface UsersAdminController {
    /**
     * Возвращает информацию обо всех пользователях (учитываются параметры ограничения выборки),
     * либо о конкретных (учитываются указанные идентификаторы)
     * В случае, если по заданным фильтрам не найдено ни одного пользователя,
     * возвращает пустой список
     *
     * @param ids  id пользователей
     * @param from количество элементов, которые нужно пропустить для формирования текущего набора
     * @param size количество элементов в наборе
     * @return 200 - Пользователи найдены List[UserDto]
     * 400 - Запрос составлен некорректно ApiError
     */
    @GetMapping()
    List<UserDto> getUsers(@RequestParam List<Integer> ids, @RequestParam(defaultValue = "0") Integer from, @RequestParam(defaultValue = "10") Integer size);

    /**
     * @param newUserRequest Данные добавляемого пользователя
     * @return 201 - Пользователь зарегистрирован UserDto
     * 400 - Запрос составлен некорректно ApiError
     * 409 - Нарушение целостности данных ApiError
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    UserDto setUser(@RequestBody NewUserRequest newUserRequest);

    /**
     * @param userId id пользователя
     *               204 - Пользователь удален HttpStatus
     *               404 - Пользователь не найден или недоступен ApiError
     */
    @DeleteMapping("{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteUser(@PathVariable Integer userId);
}
