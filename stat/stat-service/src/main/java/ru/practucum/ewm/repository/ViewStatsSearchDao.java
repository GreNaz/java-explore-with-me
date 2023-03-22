package ru.practucum.ewm.repository;

import dto.ViewStatsDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface ViewStatsSearchDao {
    List<ViewStatsDTO> getStats(LocalDateTime start,
                                LocalDateTime end,
                                List<String> uris,
                                boolean unique
    );
}
