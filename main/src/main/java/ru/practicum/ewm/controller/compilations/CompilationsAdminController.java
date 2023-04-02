package ru.practicum.ewm.controller.compilations;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.model.compilations.CompilationDto;
import ru.practicum.ewm.model.compilations.NewCompilationDto;
import ru.practicum.ewm.model.compilations.UpdateCompilationRequest;

/**
 * API для работы с подборками событий
 */
@RestController
@RequestMapping("/admin/compilations")
public interface CompilationsAdminController {

    /**
     * @param newCompilationDto данные новой подборки
     * @return 201 - Подборка добавлена CompilationDto
     * 400 - Запрос составлен некорректно ApiError
     * 409 - Нарушение целостности данных ApiError
     */
    @PostMapping
    CompilationDto setCompilation(
            @RequestBody NewCompilationDto newCompilationDto
    );

    /**
     * @param compId id подборки
     * @return 204 - Подборка удалена
     * 404 - Подборка не найдена или недоступна ApiError
     */
    @DeleteMapping("{compId}")
    HttpStatus deleteCompilation(
            @PathVariable Integer compId);

    /**
     * @param updateCompilationRequest данные для обновления подборки
     * @param compId                   id подборки
     * @return 200 Подборка обновлена CompilationDto
     * 404 Подборка не найдена или недоступна ApiError
     */
    @PatchMapping("{compId}")
    CompilationDto updateCompilation(
            @RequestBody UpdateCompilationRequest updateCompilationRequest,
            @PathVariable Integer compId);
}


