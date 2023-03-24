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
    @Email
    private String email;
    @NotBlank
    private String name;
}
