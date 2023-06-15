package ru.practicum.ewm.repository.location;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.ewm.model.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
