package ru.practicum.ewm.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserShortDto {
    @NotNull
    private Integer id;
    @NotBlank
    private String name;
}
