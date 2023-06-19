package ru.practicum.ewm.controller.comment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.model.comments.dto.CommentDtoCreate;
import ru.practicum.ewm.model.comments.dto.CommentDtoResponse;
import ru.practicum.ewm.model.comments.dto.CommentDtoUpdate;
import ru.practicum.ewm.service.comment.CommentService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("{eventId}/comments")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDtoResponse> getCommentsByEventId(@PathVariable Long eventId,
                                                         @RequestParam(required = false, defaultValue = "0", name = "from") Integer from,
                                                         @RequestParam(required = false, defaultValue = "10", name = "size") Integer size) {
        return commentService.getCommentsByEventId(eventId, from, size);
    }

    @PostMapping("comments/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDtoResponse addComment(@PathVariable Long userId,
                                         @Valid @RequestBody CommentDtoCreate commentDtoCreate) {
        return commentService.addComment(commentDtoCreate, userId);
    }

    @PatchMapping("comments/{userId}/{commentId}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDtoResponse updateComment(@PathVariable Long userId,
                                            @PathVariable Long commentId,
                                            @Valid @RequestBody CommentDtoUpdate commentDtoUpdate) {
        return commentService.updateComment(commentDtoUpdate, commentId, userId);
    }

    @GetMapping("comments/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDtoResponse> getCommentByAuthorId(@PathVariable Long userId,
                                                         @RequestParam(required = false, defaultValue = "0", name = "from") Integer from,
                                                         @RequestParam(required = false, defaultValue = "10", name = "size") Integer size) {
        return commentService.getCommentsByAuthorId(userId, from, size);
    }

    @DeleteMapping("comments/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }

}
