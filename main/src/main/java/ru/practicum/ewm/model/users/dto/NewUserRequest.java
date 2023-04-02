package ru.practicum.ewm.model.users.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * Данные нового пользователя
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewUserRequest {
    @NotBlank
    private String name;
    @Email
    private String email;
}