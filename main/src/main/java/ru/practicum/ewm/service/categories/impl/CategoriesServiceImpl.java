package ru.practicum.ewm.service.categories.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.model.categories.Category;
import ru.practicum.ewm.model.categories.dto.CategoryDto;
import ru.practicum.ewm.model.categories.CategoryMapper;
import ru.practicum.ewm.model.categories.dto.NewCategoryDto;
import ru.practicum.ewm.model.errors.NotFoundException;
import ru.practicum.ewm.repository.categories.CategoriesRepository;
import ru.practicum.ewm.service.categories.CategoriesService;

import java.util.List;
import java.util.stream.Collectors;

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
    public void deleteCategory(Integer catId) {
        repository.delete(checkCategoryExist(catId));
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer catId) {
        Category category = checkCategoryExist(catId);
        if (!categoryDto.getName().isBlank()) {
            category.setName(categoryDto.getName());
        }
        return CategoryMapper.toCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getCategories(Pageable pageable) {
        return repository.findAll(pageable).stream()
                .map(CategoryMapper::toCategoryDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategory(Integer catId) {
        Category category = checkCategoryExist(catId);
        return CategoryMapper.toCategoryDto(category);
    }

    private Category checkCategoryExist(Integer catId) {
        return repository.findById(catId).orElseThrow(()
                -> new NotFoundException("Category with id = " + catId + " was not found"));
    }
}
