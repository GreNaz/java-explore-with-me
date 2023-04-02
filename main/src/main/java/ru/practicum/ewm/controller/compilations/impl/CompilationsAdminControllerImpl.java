package ru.practicum.ewm.controller.compilations.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.controller.compilations.CompilationsAdminController;
import ru.practicum.ewm.model.compilations.dto.CompilationDto;
import ru.practicum.ewm.model.compilations.dto.NewCompilationDto;
import ru.practicum.ewm.model.compilations.dto.UpdateCompilationRequest;

@RestController
@RequiredArgsConstructor
public class CompilationsAdminControllerImpl implements CompilationsAdminController {

    public CompilationDto setCompilation(
            NewCompilationDto newCompilationDto
    ) {
        return null;
    }

    public HttpStatus deleteCompilation(
            Integer compId) {
        return null;
    }

    public CompilationDto updateCompilation(
            UpdateCompilationRequest updateCompilationRequest,
            Integer compId) {
        return null;
    }
}
