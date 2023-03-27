package ru.practicum.ewm.model.compilations;

import ru.practicum.ewm.model.events.EventShortDto;

import javax.validation.constraints.NotNull;

/**
 * Подборка событий
 */
public class CompilationDto {
    private EventShortDto events;
    @NotNull
    private Integer id;
    private Boolean pinned; //Закреплена ли подборка на главной странице сайта
    private String title; //Заголовок подборки
}
