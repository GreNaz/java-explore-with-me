package ru.practicum.ewm.model.compilations.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * Подборка событий
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewCompilationDto {

    private List<Integer> events; //Список идентификаторов событий входящих в подборку

    private Boolean pinned; //Закреплена ли подборка на главной странице сайта

    @NotBlank
    private String title; //Заголовок подборки
}
