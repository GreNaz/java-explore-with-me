package ru.practicum.ewm.service.categories;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.model.categories.Category;
import ru.practicum.ewm.model.categories.CategoryDto;
import ru.practicum.ewm.model.categories.CategoryMapper;
import ru.practicum.ewm.model.categories.NewCategoryDto;
import ru.practicum.ewm.repository.categories.CategoriesRepository;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CategoriesServiceImpl implements CategoriesService {

    private final CategoriesRepository repository;

    @Override
    public CategoryDto setCategory(NewCategoryDto newCategoryDto) {
        Category newCategory = repository.save(CategoryMapper.toCategory(newCategoryDto));
        return CategoryMapper.toCategoryDto(newCategory);
    }

    @Override
    public ResponseEntity<Object> deleteCategory(Integer catId) {
        repository.deleteById(catId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer catId) {
        Category category = repository.findById(catId).orElseThrow(()
                -> new NotFoundException("Category with id = " + catId + " was not found"));

        if (!Objects.isNull(categoryDto.getId()) && !categoryDto.getName().isBlank()) {
            category.setName(categoryDto.getName());
        }

        return CategoryMapper.toCategoryDto(category);
    }
}
