package ru.practicum.ewm.controller.compilations.impl;

import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.controller.compilations.CompilationsController;
import ru.practicum.ewm.model.compilations.CompilationDto;

import java.util.List;

@RestController
public class CompilationsControllerImpl implements CompilationsController {

    public List<CompilationDto> getCompilations(
            Boolean pinned,
            Integer from,
            Integer size
    ) {
        return null;
    }


    public CompilationDto getCompilation(
            Integer compId) {
        return null;
    }
}
