package ru.practicum.ewm.model.users.dto;

import lombok.*;

/**
 * Пользователь cокращенное
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserShortDto {
    private Long id;
    private String name;
}
