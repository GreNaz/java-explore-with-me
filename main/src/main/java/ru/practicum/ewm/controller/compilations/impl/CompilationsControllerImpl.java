package ru.practicum.ewm.controller.compilations.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.controller.compilations.CompilationsController;
import ru.practicum.ewm.model.compilations.dto.CompilationDto;
import ru.practicum.ewm.service.compilations.CompilationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompilationsControllerImpl implements CompilationsController {

    private final CompilationService service;

    public List<CompilationDto> getCompilations(Boolean pinned, Integer from, Integer size) {
        Pageable pageable = PageRequest.of(from, size);
        return service.getCompilations(pinned, pageable);
    }


    public CompilationDto getCompilation(Integer compId) {
        return service.getCompilation(compId);
    }
}
