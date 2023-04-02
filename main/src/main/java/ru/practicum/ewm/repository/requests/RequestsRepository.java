package ru.practicum.ewm.repository.requests;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.ewm.model.requests.ParticipationRequest;


@Repository
public interface RequestsRepository extends JpaRepository<ParticipationRequest, Integer> {
}
