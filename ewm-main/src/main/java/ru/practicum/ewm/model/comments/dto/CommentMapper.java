package ru.practicum.ewm.model.comments.dto;

import org.mapstruct.*;
import ru.practicum.ewm.model.comments.Comment;
import ru.practicum.ewm.model.events.EventMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {EventMapper.class})
public interface CommentMapper {

    Comment toEntity(CommentDtoCreate commentDtoCreate);

    @Mapping(source = "author.name", target = "authorName")
    CommentDtoResponse toDto(Comment comment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(CommentDtoUpdate commentDtoUpdate, @MappingTarget Comment comment);
}