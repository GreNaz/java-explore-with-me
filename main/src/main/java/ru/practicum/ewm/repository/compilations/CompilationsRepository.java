package ru.practicum.ewm.repository.compilations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.ewm.model.compilations.Compilation;


@Repository
public interface CompilationsRepository extends JpaRepository<Compilation, Integer> {
}
