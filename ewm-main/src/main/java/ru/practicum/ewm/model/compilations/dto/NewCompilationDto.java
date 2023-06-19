package ru.practicum.ewm.model.compilations.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    private List<Long> events; //Список идентификаторов событий входящих в подборку

    private boolean pinned; //Закреплена ли подборка на главной странице сайта

    @NotBlank
    @Size(max = 50)
    private String title; //Заголовок подборки
}
