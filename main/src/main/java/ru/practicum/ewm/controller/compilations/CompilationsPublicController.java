package ru.practicum.ewm.controller.compilations;

import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.model.compilations.dto.CompilationDto;

import java.util.List;

/**
 * Публичный API для работы с подборками событий
 */
@RestController
@RequestMapping("/compilations")
public interface CompilationsPublicController {
    /**
     * @param pinned искать только закрепленные/не закрепленные подборки
     * @param from   количество элементов, которые нужно пропустить для формирования текущего набора
     * @param size   количество элементов в наборе
     * @return Получение подборок событий
     * В случае, если по заданным фильтрам не найдено ни одной подборки,
     * возвращает пустой список
     */
    @GetMapping
    List<CompilationDto> getCompilations(
            @RequestParam(required = false) Boolean pinned,
            @RequestParam(defaultValue = "0") Integer from,
            @RequestParam(defaultValue = "10") Integer size
    );

    /**
     * @param compId id подборки
     * @return Получение подборки событий по его id
     * В случае, если подборки с заданным id не найдено,
     * возвращает статус код 404 ApiError.
     * Запрос составлен некорректно - 400 ApiError
     */
    @GetMapping("{compId}")
    CompilationDto getCompilation(@PathVariable Integer compId);
}
