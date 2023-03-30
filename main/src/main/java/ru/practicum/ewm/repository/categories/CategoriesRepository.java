package ru.practicum.ewm.repository.categories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.ewm.model.categories.Category;

@Repository
public interface CategoriesRepository extends JpaRepository<Category, Integer> {
}
