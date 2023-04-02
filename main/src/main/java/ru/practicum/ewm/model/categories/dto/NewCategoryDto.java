package ru.practicum.ewm.model.categories.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * Данные для добавления новой категории
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewCategoryDto {
    @NotNull
    private String name; //Название категории
}
