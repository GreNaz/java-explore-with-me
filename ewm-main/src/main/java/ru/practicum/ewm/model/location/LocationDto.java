package ru.practicum.ewm.model.location;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {
    private Integer id;
    @NotNull
    private Float lat;
    @NotNull
    private Float lon;
}
