package ru.practicum.ewm.model.compilations;

import lombok.experimental.UtilityClass;
import ru.practicum.ewm.model.compilations.dto.CompilationDto;
import ru.practicum.ewm.model.compilations.dto.NewCompilationDto;
import ru.practicum.ewm.model.events.Event;
import ru.practicum.ewm.model.events.EventMapper;
import ru.practicum.ewm.model.events.dto.EventShortDto;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class CompilationMapper {
    public static Compilation toCompilation(NewCompilationDto newCompilationDto, List<Event> events) {
        if (newCompilationDto.getPinned() == null){
            newCompilationDto.setPinned(false);
        }
        return Compilation.builder()
                .title(newCompilationDto.getTitle())
                .pinned(newCompilationDto.getPinned())
                .events(events).build();
    }

    public static CompilationDto toCompilationDto(Compilation compilation) {
        List<EventShortDto> shortEvents = compilation.getEvents().stream()
                .map(EventMapper.EVENT_MAPPER::toEventShortDto)
                .collect(Collectors.toList());
        return CompilationDto.builder()
                .id(compilation.getId())
                .events(shortEvents)
                .title(compilation.getTitle())
                .pinned(compilation.getPinned()).build();
    }
}
