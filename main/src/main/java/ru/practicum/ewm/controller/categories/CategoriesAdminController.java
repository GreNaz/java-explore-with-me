package ru.practicum.ewm.controller.categories;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.model.categories.CategoryDto;
import ru.practicum.ewm.model.categories.NewCategoryDto;

/**
 * API для работы с категориями
 */

@RestController
@RequestMapping("/admin/categories")
public interface CategoriesAdminController {

    /**
     * @param newCategoryDto данные добавляемой категории
     * @return имя категории должно быть уникальным
     * 201 - Категория добавлена CategoryDto
     * 400 - Запрос составлен некорректно ApiError
     * 409 - Нарушение целостности данных ApiError
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CategoryDto setCategory(@RequestBody NewCategoryDto newCategoryDto);

    /**
     * @param catId id категории
     */
    @DeleteMapping("{catId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCategory(@PathVariable Integer catId);

    /**
     * @param categoryDto Данные категории для изменения
     * @param catId       id категории
     * @return имя категории должно быть уникальным
     * 200 - Данные категории изменены
     * 404 - Категория не найдена или недоступна ApiError
     * 409 - Нарушение целостности данных ApiError
     */
    @PatchMapping("{catId}")
    CategoryDto updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable Integer catId);

}
