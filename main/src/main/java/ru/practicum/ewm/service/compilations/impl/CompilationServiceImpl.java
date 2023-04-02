package ru.practicum.ewm.service.compilations.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.repository.compilations.CompilationsRepository;
import ru.practicum.ewm.service.compilations.CompilationService;

@Service
@RequiredArgsConstructor
public class CompilationServiceImpl implements CompilationService {
    private final CompilationsRepository repository;
}
