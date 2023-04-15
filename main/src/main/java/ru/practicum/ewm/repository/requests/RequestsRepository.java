package ru.practicum.ewm.repository.requests;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.practicum.ewm.model.requests.ParticipationRequest;
import ru.practicum.ewm.model.requests.RequestStatus;

import java.util.List;
import java.util.Optional;


@Repository
public interface RequestsRepository extends JpaRepository<ParticipationRequest, Integer> {
    Optional<ParticipationRequest> findByEventIdAndRequesterId(Integer eventId, Integer userId);

    List<ParticipationRequest> findByRequesterId(Integer requester_id);

    @Query("select participationRequest from ParticipationRequest participationRequest " +
            "where participationRequest.event.id = :eventId " +
            "and participationRequest.event.initiator.id = :userId")
    List<ParticipationRequest> findByEventIdAndInitiatorId(@Param("eventId") Integer eventId,
                                                           @Param("userId") Integer userId);

    @Query("select p from ParticipationRequest p where p.event.id = :eventId and p.status = 'CONFIRMED'")
    List<ParticipationRequest> findByEventIdConfirmed(@Param("eventId") Integer eventId);

    List<ParticipationRequest> findAllByEventIdAndStatus(Integer eventId, RequestStatus requestStatus);
}
