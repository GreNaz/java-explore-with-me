package ru.practicum.ewm.controller.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.model.comments.dto.CommentDtoResponse;
import ru.practicum.ewm.model.comments.dto.UpdateCommentAdminRequest;
import ru.practicum.ewm.service.comment.CommentAdminService;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin/events")
@RequiredArgsConstructor
public class CommentsAdminController {

    private final CommentAdminService commentAdminService;

    @GetMapping("/comments/{commentId}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDtoResponse getCommentById(@PathVariable Long commentId) {
        return commentAdminService.getCommentById(commentId);
    }

    @PatchMapping("comments/{commentId}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDtoResponse updateCommentStatus(@PathVariable Long commentId,
                                                  @Valid @RequestBody UpdateCommentAdminRequest adminRequest) {
        return commentAdminService.updateCommentByAdmin(commentId, adminRequest);
    }
}
