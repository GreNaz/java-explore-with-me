package ru.practicum.ewm.statistic;


import dto.EndpointHitDTO;
import lombok.experimental.UtilityClass;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@UtilityClass
public class HitMapper {
    public static EndpointHitDTO toEndpointHit(String app, HttpServletRequest request) {
        return new EndpointHitDTO(null,
                app,
                request.getRequestURI(),
                request.getRemoteAddr(),
                LocalDateTime.now());
    }
}
