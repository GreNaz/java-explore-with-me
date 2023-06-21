package ru.practicum.ewm.controller.comment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.model.comments.dto.CommentDtoResponse;
import ru.practicum.ewm.service.comment.CommentService;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class CommentPublicController {

    private final CommentService commentService;

    @GetMapping("{eventId}/comments")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDtoResponse> getCommentsByEventId(@PathVariable Long eventId,
                                                         @PositiveOrZero @RequestParam(defaultValue = "0", name = "from") Integer from,
                                                         @Positive @RequestParam(defaultValue = "10", name = "size") Integer size) {
        return commentService.getCommentsByEventId(eventId, from, size);
    }
}