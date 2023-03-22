package ru.practucum.ewm.repository;

import dto.ViewStatsDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ru.practucum.ewm.model.EndpointHit;
import ru.practucum.ewm.model.ViewStats;
import ru.practucum.ewm.model.ViewStatsMapper;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Slf4j
@RequiredArgsConstructor
public class ViewStatsSearchDao {
    private final EntityManager entityManager;

    public List<ViewStatsDTO> getStats(LocalDateTime start,
                                       LocalDateTime end,
                                       List<String> uris,
                                       boolean unique
    ) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<ViewStats> viewStatsCriteriaQuery = criteriaBuilder.createQuery(ViewStats.class);

        Root<EndpointHit> root = viewStatsCriteriaQuery.from(EndpointHit.class);

        List<Predicate> predicateList = new ArrayList<>();

        viewStatsCriteriaQuery.select(criteriaBuilder.construct(ViewStats.class,
                        root.get("uri"),
                        root.get("app"),
                        unique ? criteriaBuilder.countDistinct(root.get("ip")) : criteriaBuilder.count(root.get("ip"))
                )
        );

        viewStatsCriteriaQuery.groupBy(
                root.get("app"),
                root.get("uri"),
                root.get("ip")
        );

        Predicate betweenPredicate = criteriaBuilder.between(root.get("timestamp"), start, end);

        predicateList.add(betweenPredicate);

        Optional.ofNullable(uris).ifPresent(
                uri -> predicateList.add(criteriaBuilder.equal(root.get("uri"), uri)));

        viewStatsCriteriaQuery.where(predicateList.toArray(new Predicate[]{}));

        TypedQuery<ViewStats> query = entityManager.createQuery(viewStatsCriteriaQuery);
        log.info(query.getResultList().toString());
        return query.getResultList().stream().map(ViewStatsMapper::toViewStatsDTO).collect(Collectors.toList());
    }
}
