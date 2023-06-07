package ru.practicum.ewm.model.compilations.dto;

import lombok.*;

import java.util.List;

/**
 * Изменение информации о подборке событий.
 * Если поле в запросе не указано (равно null)
 * - значит изменение этих данных не треубется.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCompilationRequest {
    private List<Long> events; // Список id событий подборки для полной замены текущего списка
    private Boolean pinned; // Закреплена ли подборка на главной странице сайта
    private String title; // Заголовок подборки
}
