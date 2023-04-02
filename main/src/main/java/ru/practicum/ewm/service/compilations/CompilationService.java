package ru.practicum.ewm.service.compilations;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.model.compilations.dto.CompilationDto;
import ru.practicum.ewm.model.compilations.dto.NewCompilationDto;
import ru.practicum.ewm.model.compilations.dto.UpdateCompilationRequest;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface CompilationService {
    @Transactional
    CompilationDto setCompilation(NewCompilationDto newCompilationDto);

    @Transactional
    void deleteCompilation(Integer compId);

    @Transactional
    CompilationDto updateCompilation(UpdateCompilationRequest updateCompilationRequest, Integer compId);

    List<CompilationDto> getCompilations(Boolean pinned, Pageable pageable);

    CompilationDto getCompilation(Integer compId);
}
