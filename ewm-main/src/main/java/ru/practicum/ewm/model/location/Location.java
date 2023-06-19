package ru.practicum.ewm.model.location;

import lombok.*;

import javax.persistence.*;

/**
 * Широта и долгота места проведения события
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LOCATIONS")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private Float lat; //Широта
    private Float lon; //Долгота
}
