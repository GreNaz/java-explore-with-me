package ru.practicum.ewm.model;

import javax.validation.constraints.NotNull;

//Данные для добавления новой категории
public class NewCategoryDto {
    @NotNull
    private String name; //Название категории
}
