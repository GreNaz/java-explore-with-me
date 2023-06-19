package ru.practicum.ewm.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Сведения об ошибке
 */

@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
    private List<String> errors; // Список стектрейсов или описания ошибок
    private String message; //Сообщение об ошибке
    private String reason; //Общее описание причины ошибки
    private HttpStatus status; //Код статуса HTTP-ответа
    private LocalDateTime timestamp; //Дата и время когда произошла ошибка (в формате "yyyy-MM-dd HH:mm:ss")
}
