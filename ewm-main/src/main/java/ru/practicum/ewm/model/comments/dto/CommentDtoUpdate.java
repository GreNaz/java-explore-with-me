package ru.practicum.ewm.model.comments.dto;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@Jacksonized
@RequiredArgsConstructor
@AllArgsConstructor
public class CommentDtoUpdate {
    @NotNull(message = "'text' can not be null")
    @Size(min = 3, max = 255)
    private String text;
}
