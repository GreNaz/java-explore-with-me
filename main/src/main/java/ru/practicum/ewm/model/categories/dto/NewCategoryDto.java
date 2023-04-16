package ru.practicum.ewm.model.categories.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * Данные для добавления новой категории
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewCategoryDto {
    @NotBlank
    private String name; //Название категории
}
