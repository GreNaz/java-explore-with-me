package ru.practicum.ewm.model;

import javax.validation.constraints.NotBlank;

//Категория
public class CategoryDto {
    private Integer id; //Идентификатор категории
    @NotBlank(message = "Name can not be blank")
    private String name; //Название категории
}
