package ru.practicum.ewm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.model.CompilationDto;

/**
 * Публичный API для работы с подборками событий
 */
@RestController("/compilations")
public class CompilationsController {

    /**
     * @param pinned искать только закрепленные/не закрепленные подборки
     * @param from   количество элементов, которые нужно пропустить для формирования текущего набора
     * @param size   количество элементов в наборе
     * @return Получение подборок событий
     * В случае, если по заданным фильтрам не найдено ни одной подборки,
     * возвращает пустой список
     */
    @GetMapping
    CompilationDto getCompilations(
            @RequestParam(required = false) Boolean pinned,
            @RequestParam(required = false) Integer from,
            @RequestParam(required = false) Integer size
    ) {
        return null;
    }

    /**
     * @param compId id подборки
     * @return Получение подборки событий по его id
     * В случае, если подборки с заданным id не найдено,
     * возвращает статус код 404 ApiError.
     * Запрос составлен некорректно - 400 ApiError
     */
    @GetMapping("{compId}")
    CompilationDto getCompilation(
            @PathVariable Integer compId) {
        return null;
    }

}
