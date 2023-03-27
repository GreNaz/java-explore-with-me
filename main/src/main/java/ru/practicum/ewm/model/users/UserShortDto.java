package ru.practicum.ewm.model.users;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
/**
 * Пользователь cокращенное
 */
public class UserShortDto {
    @NotNull
    private Integer id;
    @NotBlank
    private String name;
}
