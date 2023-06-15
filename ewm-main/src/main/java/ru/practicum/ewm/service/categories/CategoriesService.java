package ru.practicum.ewm.service.categories;

import org.springframework.data.domain.Pageable;
import ru.practicum.ewm.model.categories.dto.CategoryDto;
import ru.practicum.ewm.model.categories.dto.NewCategoryDto;

import javax.transaction.Transactional;
import java.util.List;

public interface CategoriesService {
    @Transactional
    CategoryDto setCategory(NewCategoryDto newCategoryDto);

    @Transactional
    void deleteCategory(Integer catId);

    @Transactional
    CategoryDto updateCategory(CategoryDto categoryDto, Integer catId);

    List<CategoryDto> getCategories(Pageable pageable);

    CategoryDto getCategory(Integer catId);
}
