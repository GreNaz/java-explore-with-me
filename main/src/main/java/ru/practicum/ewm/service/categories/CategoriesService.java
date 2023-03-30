package ru.practicum.ewm.service.categories;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.model.categories.CategoryDto;
import ru.practicum.ewm.model.categories.NewCategoryDto;

@Service
public interface CategoriesService {

    CategoryDto setCategory(NewCategoryDto newCategoryDto);

    ResponseEntity<Object> deleteCategory(Integer catId);

    CategoryDto updateCategory(CategoryDto categoryDto, Integer catId);
}
