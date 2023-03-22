package ru.practucum.ewm.service;

import dto.EndpointHitDTO;
import dto.ViewStatsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practucum.ewm.model.EndpointHitMapper;
import ru.practucum.ewm.repository.StatRepository;
import ru.practucum.ewm.repository.ViewStatsSearchDao;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StatServiceImpl implements StatService {
    private final StatRepository repository;
    private final ViewStatsSearchDao viewStatsSearchDao;

    @Override
    public EndpointHitDTO save(EndpointHitDTO endpointHitDTO) {
        repository.save(EndpointHitMapper.toEndpointHit(endpointHitDTO));
        return endpointHitDTO;
    }

    @Override
    public List<ViewStatsDTO> getStat(LocalDateTime start,
                                      LocalDateTime end,
                                      List<String> uris,
                                      boolean unique) {
//        if (unique) {
//            return repository.getStatsUnique(start, end, uris).stream()
//                    .map(ViewStatsMapper::toViewStatsDTO)
//                    .collect(Collectors.toList());
//        } else {
//            return repository.getStatsNotUnique(start, end, uris).stream()
//                    .map(ViewStatsMapper::toViewStatsDTO)
//                    .collect(Collectors.toList());
//        }
        return viewStatsSearchDao.getStats(start, end, uris, unique);
    }
}
