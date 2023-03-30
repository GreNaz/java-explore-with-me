package ru.practicum.ewm.model.categories;

import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * Категория
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Integer id; //Идентификатор категории
    @NotBlank
    private String name; //Название категории
}
