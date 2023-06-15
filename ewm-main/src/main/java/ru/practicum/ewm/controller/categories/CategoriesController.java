package ru.practicum.ewm.controller.categories;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.model.categories.dto.CategoryDto;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

/**
 * Публичный API для работы с категориями
 */

@Validated
@RestController
@RequestMapping("/categories")
public interface CategoriesController {
    /**
     * @param from количество категорий, которые нужно пропустить для формирования текущего набора
     * @param size количество категорий в наборе
     * @return Получение категорий
     * В случае, если по заданным фильтрам не найдено ни одной категории, возвращает пустой список CategoryDto
     * Категории найдены - 200 List<CategoryDto>
     * Запрос составлен некорректно - 400 ApiError
     */
    @GetMapping
    List<CategoryDto> getCategories(
            @PositiveOrZero @RequestParam(defaultValue = "0") Integer from,
            @Positive @RequestParam(defaultValue = "10") Integer size
    );

    /**
     * @param catId id категории
     * @return В случае, если категории с заданным id не найдено, возвращает статус код 404
     * 200 - Категория найдена CategoryDto
     * 400 - Запрос составлен некорректно ApiError
     * 404 - Категория не найдена или недоступна ApiError
     */
    @GetMapping("{catId}")
    CategoryDto getCategory(@Positive @PathVariable Integer catId);
}
