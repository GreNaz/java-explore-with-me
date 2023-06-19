package ru.practicum.ewm.model.compilations.dto;

import lombok.*;
import ru.practicum.ewm.model.events.dto.EventShortDto;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Подборка событий
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompilationDto {

    @NotNull
    private Integer id;

    private Boolean pinned; //Закреплена ли подборка на главной странице сайта

    private String title; //Заголовок подборки

    private List<EventShortDto> events;
}
