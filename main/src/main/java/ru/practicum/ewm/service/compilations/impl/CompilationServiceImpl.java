package ru.practicum.ewm.service.compilations.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.model.compilations.Compilation;
import ru.practicum.ewm.model.compilations.CompilationMapper;
import ru.practicum.ewm.model.compilations.dto.CompilationDto;
import ru.practicum.ewm.model.compilations.dto.NewCompilationDto;
import ru.practicum.ewm.model.compilations.dto.UpdateCompilationRequest;
import ru.practicum.ewm.repository.compilations.CompilationsRepository;
import ru.practicum.ewm.service.compilations.CompilationService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompilationServiceImpl implements CompilationService {
    private final CompilationsRepository repository;

    @Override
    public CompilationDto setCompilation(NewCompilationDto newCompilationDto) {
        Compilation compilation = repository.save(CompilationMapper.toCompilation(newCompilationDto, null));
        return CompilationMapper.toCompilationDto(compilation);
    }

    @Override
    public void deleteCompilation(Integer compId) {
        repository.deleteById(compId);
    }

    @Override
    public CompilationDto updateCompilation(UpdateCompilationRequest updateCompilationRequest, Integer compId) {
        return null;
    }

    @Override
    public List<CompilationDto> getCompilations(Boolean pinned, Pageable pageable) {
        return null;
    }

    @Override
    public CompilationDto getCompilation(Integer compId) {
        return null;
    }
}
