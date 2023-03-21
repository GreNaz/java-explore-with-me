package ru.practucum.ewm.controller;

import dto.EndpointHitDTO;
import dto.ViewStatsDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import ru.practucum.ewm.service.StatService;

import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
public class StatController {
    private final StatService service;

    // Сохранение информации о том,
    // что на uri конкретного сервиса был отправлен запрос пользователем.
    // Название сервиса, uri и ip пользователя указаны в теле запроса.
    @PostMapping("/hit")
    public EndpointHitDTO save(@RequestBody EndpointHitDTO endpointHitDTO) {
        return service.save(endpointHitDTO);
    }

    @GetMapping("/stats")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public List<ViewStatsDTO> getStat(
            //Дата и время конца диапазона за который нужно выгрузить статистику (в формате "yyyy-MM-dd HH:mm:ss")
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end,
            // Список uri для которых нужно выгрузить статистику
            @RequestParam(required = false) List<String> uris,
            // Нужно ли учитывать только уникальные посещения (только с уникальным ip)
            @RequestParam(defaultValue = "false") boolean unique) {
        return service.getStat(start, end, uris, unique);
    }
}
