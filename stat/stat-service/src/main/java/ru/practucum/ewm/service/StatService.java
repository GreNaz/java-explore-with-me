package ru.practucum.ewm.service;

import dto.EndpointHitDTO;
import dto.ViewStatsDTO;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface StatService {
    @Transactional
    EndpointHitDTO save(EndpointHitDTO endpointHitDTO);

    List<ViewStatsDTO> getStat(LocalDateTime start,
                         LocalDateTime end,
                         List<String> uris,
                         boolean unique
    );
}
