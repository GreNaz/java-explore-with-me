package ru.practicum.ewm.model.categories;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORIES")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;
}
