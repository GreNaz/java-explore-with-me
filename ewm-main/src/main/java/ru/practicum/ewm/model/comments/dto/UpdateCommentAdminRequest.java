package ru.practicum.ewm.model.comments.dto;

import lombok.*;
import lombok.extern.jackson.Jacksonized;
import ru.practicum.ewm.model.comments.CommentStateAction;

@Getter
@Setter
@Builder
@Jacksonized
@RequiredArgsConstructor
@AllArgsConstructor
public class UpdateCommentAdminRequest {
    private CommentStateAction commentState;
}
