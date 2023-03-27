package ru.practicum.ewm.controller.categories;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.model.CategoryDto;
import ru.practicum.ewm.model.NewCategoryDto;

@RestController("/admin/categories")
public class CategoriesAdminController {

    /**
     * @param newCategoryDto данные добавляемой категории
     * @return  имя категории должно быть уникальным
     * 201 - Категория добавлена CategoryDto
     * 400 - Запрос составлен некорректно ApiError
     * 409 - Нарушение целостности данных ApiError
     */
    @PostMapping
    CategoryDto setCategory(
            @RequestBody NewCategoryDto newCategoryDto
    ) {
        return null;
    }

    /**
     * @param catId id категории
     * @return  с категорией не должно быть связано ни одного события.
     * 204 - Категория удалена
     * 404 - Категория не найдена или недоступна ApiError
     * 409 - Существуют события, связанные с категорией ApiError
     */
    @DeleteMapping("{catId}")
    HttpStatus deleteCategory(
            @PathVariable Integer catId) {
        return null;
    }

    /**
     * @param categoryDto Данные категории для изменения
     * @param catId       id категории
     * @return  имя категории должно быть уникальным
     * 200 - Данные категории изменены
     * 404 - Категория не найдена или недоступна ApiError
     * 409 - Нарушение целостности данных ApiError
     */
    @PatchMapping("{catId}")
    CategoryDto updateCategory(
            @RequestBody CategoryDto categoryDto,
            @PathVariable Integer catId) {
        return null;
    }
}
