package ru.practicum.ewm.model.users.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Пользователь cокращенное
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserShortDto {
    @NotNull
    private Integer id;
    @NotBlank
    private String name;
}
