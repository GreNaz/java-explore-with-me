package ru.practucum.ewm.service;

import dto.EndpointHitDTO;
import dto.ViewStatsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practucum.ewm.controller.BadRequestException;
import ru.practucum.ewm.model.EndpointHitMapper;
import ru.practucum.ewm.repository.StatRepository;

import java.time.LocalDateTime;
import java.util.List;

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
        if (start.isAfter(end)) {
            throw new BadRequestException("Bad Request");
        }

        return repository.getStats(start, end, uris, unique);
    }
}
