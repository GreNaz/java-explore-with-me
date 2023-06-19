package ru.practicum.ewm.repository.compilations;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.ewm.model.compilations.Compilation;

import java.util.List;


public interface CompilationsRepository extends JpaRepository<Compilation, Integer> {
    List<Compilation> findAllByPinned(Boolean pinned, Pageable pageable);

    List<Compilation> findAllBy(Pageable pageable);

}
