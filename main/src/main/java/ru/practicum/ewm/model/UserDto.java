package ru.practicum.ewm.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Пользователь
 */
public class UserDto {
    @NotNull
    private Integer id;
    @NotBlank
    private String name;
    @Email
    private String email;
}
