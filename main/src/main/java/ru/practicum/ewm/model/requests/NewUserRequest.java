package ru.practicum.ewm.model.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
/**
 * Данные нового пользователя
 */
public class NewUserRequest {
    @NotBlank
    private String name;
    @Email
    private String email;
}
