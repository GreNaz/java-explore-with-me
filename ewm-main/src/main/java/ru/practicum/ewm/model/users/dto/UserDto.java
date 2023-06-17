package ru.practicum.ewm.model.users.dto;

import lombok.*;

/**
 * Пользователь
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String email;
}
