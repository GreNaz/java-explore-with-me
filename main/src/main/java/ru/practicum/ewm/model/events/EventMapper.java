package ru.practicum.ewm.model.events;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.practicum.ewm.model.categories.Category;
import ru.practicum.ewm.model.events.dto.EventFullDto;
import ru.practicum.ewm.model.events.dto.EventShortDto;
import ru.practicum.ewm.model.events.dto.NewEventDto;
import ru.practicum.ewm.model.users.User;

@Mapper
public interface EventMapper {
    EventMapper EVENT_MAPPER = Mappers.getMapper(EventMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", expression = "java(category)")
    @Mapping(target = "state", constant = "PENDING")
    @Mapping(target = "createdOn", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "publishedOn", expression = "java(java.time.LocalDateTime.now())")
    Event toEvent(User initiator, Category category, NewEventDto newEventDto);

    @Mapping(target = "createdOn")
    @Mapping(target = "eventDate")
    @Mapping(target = "publishedOn")
    @Mapping(target = "views", expression = "java(0)")
    @Mapping(target = "state", expression = "java(event.state().name())")
    EventFullDto toEventFullDto(Event event);

    @Mapping(target = "eventDate")
    EventShortDto toEventShortDto(Event event);

    EventShortDto toEventShortDto(EventFullDto eventFullDto);
}