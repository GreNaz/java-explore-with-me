package ru.practicum.ewm.model.compilations;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * Подборка событий
 */
public class NewCompilationDto {
    private List<Integer> events; //Список идентификаторов событий входящих в подборку
    private Boolean pinned; //Закреплена ли подборка на главной странице сайта
    @NotBlank
    private String title; //Заголовок подборки
}
