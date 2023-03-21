package ru.practucum.ewm.service;

import dto.EndpointHitDTO;
import dto.ViewStatsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practucum.ewm.model.EndpointHitMapper;
import ru.practucum.ewm.model.ViewStatsMapper;
import ru.practucum.ewm.repository.StatRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StatServiceImpl implements StatService {
    private final StatRepository repository;

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
        if (unique) {
            return repository.getStatsUnique(start, end, uris).stream()
                    .map(ViewStatsMapper::toViewStatsDTO)
                    .collect(Collectors.toList());
        } else {
            return repository.getStatsNotUnique(start, end, uris).stream()
                    .map(ViewStatsMapper::toViewStatsDTO)
                    .collect(Collectors.toList());
        }
    }
}
