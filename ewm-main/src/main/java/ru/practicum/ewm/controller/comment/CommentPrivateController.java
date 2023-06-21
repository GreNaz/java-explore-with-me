package ru.practicum.ewm.controller.comment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.model.comments.dto.CommentDtoCreate;
import ru.practicum.ewm.model.comments.dto.CommentDtoResponse;
import ru.practicum.ewm.model.comments.dto.CommentDtoUpdate;
import ru.practicum.ewm.service.comment.CommentService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class CommentPrivateController {

    private final CommentService commentService;


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
                                                         @PositiveOrZero @RequestParam(defaultValue = "0", name = "from") Integer from,
                                                         @Positive @RequestParam(defaultValue = "10", name = "size") Integer size) {
        return commentService.getCommentsByAuthorId(userId, from, size);
    }

    @DeleteMapping("comments/{commentId}/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable Long commentId,
                              @PathVariable Long userId) {
        commentService.deleteComment(commentId, userId);
    }

}
