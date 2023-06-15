package ru.practucum.ewm.repository;

import dto.ViewStatsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.practucum.ewm.model.EndpointHit;
import ru.practucum.ewm.model.ViewStats;
import ru.practucum.ewm.model.ViewStatsMapper;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ViewStatsSearchDaoImpl implements ViewStatsSearchDao {

    private final EntityManager entityManager;

    public List<ViewStatsDTO> getStats(LocalDateTime start,
                                       LocalDateTime end,
                                       List<String> uris,
                                       boolean unique
    ) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ViewStats> viewStatsCriteriaQuery = criteriaBuilder.createQuery(ViewStats.class);
        Root<EndpointHit> endpointHitRoot = viewStatsCriteriaQuery.from(EndpointHit.class);
        List<Predicate> predicateList = new ArrayList<>();

        viewStatsCriteriaQuery.select(criteriaBuilder.construct(ViewStats.class,
                        endpointHitRoot.get("uri"),
                        endpointHitRoot.get("app"),
                        unique ? criteriaBuilder.countDistinct(endpointHitRoot.get("ip")) : criteriaBuilder.count(endpointHitRoot.get("ip"))
                )
        );
        viewStatsCriteriaQuery.groupBy(
                endpointHitRoot.get("app"),
                endpointHitRoot.get("uri"),
                endpointHitRoot.get("ip")
        );
        viewStatsCriteriaQuery.orderBy(criteriaBuilder
                .desc(unique ? criteriaBuilder.countDistinct(endpointHitRoot.get("ip")) : criteriaBuilder.count(endpointHitRoot.get("ip"))));
        Predicate betweenPredicate = criteriaBuilder
                .between(endpointHitRoot.get("timestamp"), start, end);
        predicateList.add(betweenPredicate);
        if (uris != null) {
            predicateList.add(criteriaBuilder.or(uris.stream()
                    .map(uri -> criteriaBuilder.like(endpointHitRoot.get("uri"), uri))
                    .collect(Collectors.toList())
                    .toArray(Predicate[]::new)
            ));
        }
        viewStatsCriteriaQuery.where(predicateList.toArray(Predicate[]::new));

        return entityManager.createQuery(viewStatsCriteriaQuery)
                .getResultList()
                .stream()
                .map(ViewStatsMapper::toViewStatsDTO)
                .collect(Collectors.toList());
    }
}
