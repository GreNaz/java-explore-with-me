package ru.practicum.ewm.controller.compilations.impl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.controller.compilations.CompilationsAdminController;
import ru.practicum.ewm.model.compilations.CompilationDto;
import ru.practicum.ewm.model.compilations.NewCompilationDto;
import ru.practicum.ewm.model.compilations.UpdateCompilationRequest;

@RestController
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
