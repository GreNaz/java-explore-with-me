package ru.practicum.ewm.controller.categories.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.controller.categories.CategoriesController;
import ru.practicum.ewm.model.categories.CategoryDto;
import ru.practicum.ewm.service.categories.CategoriesService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoriesControllerImpl implements CategoriesController {

    private final CategoriesService service;

    public List<CategoryDto> getCategories(Integer from, Integer size) {
        return null;
    }

    public CategoryDto getCategory(Integer catId) {
        return null;
    }
}
