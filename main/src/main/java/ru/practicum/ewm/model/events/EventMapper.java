package ru.practicum.ewm.model.events;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import ru.practicum.ewm.model.categories.Category;
import ru.practicum.ewm.model.events.dto.EventFullDto;
import ru.practicum.ewm.model.events.dto.EventShortDto;
import ru.practicum.ewm.model.events.dto.NewEventDto;
import ru.practicum.ewm.model.events.dto.UpdateEventUserRequest;
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

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEventFromDto(UpdateEventUserRequest updateEventUserRequest, @MappingTarget Event event);

    @Mapping(target = "createdOn", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "eventDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "publishedOn")
    @Mapping(target = "views", expression = "java(0)")
    @Mapping(target = "state", expression = "java(event.getState().name())")
    EventFullDto toEventFullDto(Event event);

    @Mapping(target = "eventDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    EventShortDto toEventShortDto(Event event);

    @Mapping(target = "eventDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    EventShortDto toEventShortDto(EventFullDto eventFullDto);
}