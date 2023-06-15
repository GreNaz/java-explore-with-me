package ru.practicum.ewm.repository.compilations;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.ewm.model.compilations.Compilation;

import java.util.List;


@Repository
public interface CompilationsRepository extends JpaRepository<Compilation, Integer> {
    List<Compilation> findAllByPinned(Boolean pinned, Pageable pageable);

    List<Compilation> findAllBy(Pageable pageable);

}
