package ru.practicum.ewm.model.compilations;

import lombok.experimental.UtilityClass;
import ru.practicum.ewm.model.compilations.dto.CompilationDto;
import ru.practicum.ewm.model.compilations.dto.NewCompilationDto;
import ru.practicum.ewm.model.events.Event;

import java.util.List;

@UtilityClass
public class CompilationMapper {
    public static Compilation toCompilation(
            NewCompilationDto newCompilationDto,
            List<Event> events) {
        return Compilation.builder()
                .title(newCompilationDto.getTitle())
                .pinned(newCompilationDto.getPinned())
                .events(events)
                .build();
    }

    public static CompilationDto toCompilationDto(Compilation compilation) {
        return CompilationDto.builder()
                .title(compilation.getTitle())
                .pinned(compilation.getPinned())
                .build();
    }
}
