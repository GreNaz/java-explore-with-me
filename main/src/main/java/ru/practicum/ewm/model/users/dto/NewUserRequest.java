package ru.practicum.ewm.model.users.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @NotNull
    @Size(min = 2, max = 250)
    private String name;
    @Email
    @NotBlank
    @Size(max = 254, min = 6)
    private String email;
}
