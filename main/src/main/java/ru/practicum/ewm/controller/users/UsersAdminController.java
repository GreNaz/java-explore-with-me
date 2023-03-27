package ru.practicum.ewm.controller.users;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.model.NewUserRequest;
import ru.practicum.ewm.model.UserDto;

import java.util.List;

/**
 * API для работы с пользователями
 */
@RestController("/admin/users")
public class UsersAdminController {

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
    List<UserDto> getUser(
            @RequestParam List<Integer> ids,
            @RequestParam(defaultValue = "0") Integer from,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        return null;
    }

    /**
     * @param newUserRequest Данные добавляемого пользователя
     * @return 201 - Пользователь зарегистрирован UserDto
     * 400 - Запрос составлен некорректно ApiError
     * 409 - Нарушение целостности данных ApiError
     */
    @PostMapping
    UserDto setUser(
            @RequestBody NewUserRequest newUserRequest) {
        return null;
    }

    /**
     * @param userId id пользователя
     * @return 204 - Пользователь удален HttpStatus
     * 404 - Пользователь не найден или недоступен ApiError
     */
    @DeleteMapping("{userId}")
    HttpStatus deleteUser(
            @PathVariable Integer userId) {
        return null;
    }
}
