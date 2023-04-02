package ru.practicum.ewm.controller.categories.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.controller.categories.CategoriesAdminController;
import ru.practicum.ewm.model.categories.CategoryDto;
import ru.practicum.ewm.model.categories.NewCategoryDto;
import ru.practicum.ewm.service.categories.CategoriesService;

@RestController
@RequiredArgsConstructor
public class CategoriesAdminControllerImpl implements CategoriesAdminController {

    private final CategoriesService service;

    @Override
    public CategoryDto setCategory(NewCategoryDto newCategoryDto) {
        return service.setCategory(newCategoryDto);
    }

    @Override
    public void deleteCategory(Integer catId) {
        service.deleteCategory(catId);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer catId) {
        return service.updateCategory(categoryDto, catId);
    }
}
