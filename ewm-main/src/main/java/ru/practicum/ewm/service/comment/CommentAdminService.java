package ru.practicum.ewm.service.comment;

import ru.practicum.ewm.model.comments.dto.CommentDtoResponse;
import ru.practicum.ewm.model.comments.dto.UpdateCommentAdminRequest;

public interface CommentAdminService {

    CommentDtoResponse updateCommentByAdmin(Long commentId,
                                            UpdateCommentAdminRequest updateCommentAdminRequest);

    CommentDtoResponse getCommentById(Long commentId);
}
