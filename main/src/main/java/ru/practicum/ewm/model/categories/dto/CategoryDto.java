package ru.practicum.ewm.model.categories.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
    @Size(max = 50)
    private String name; //Название категории
}
