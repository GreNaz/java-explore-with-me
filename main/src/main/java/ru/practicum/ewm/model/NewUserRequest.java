package ru.practicum.ewm.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

//Данные нового пользователя
public class NewUserRequest {
    @NotBlank
    private String name;
    @Email
    private String email;
}
