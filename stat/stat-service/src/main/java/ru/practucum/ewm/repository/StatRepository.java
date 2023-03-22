package ru.practucum.ewm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practucum.ewm.model.EndpointHit;

@Repository
public interface StatRepository extends JpaRepository<EndpointHit, Integer>, ViewStatsSearchDao {
}
