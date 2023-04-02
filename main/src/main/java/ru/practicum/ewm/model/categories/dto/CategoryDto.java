package ru.practicum.ewm.model.categories.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * Категория
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private Integer id; //Идентификатор категории
    @NotBlank
    private String name; //Название категории
}
