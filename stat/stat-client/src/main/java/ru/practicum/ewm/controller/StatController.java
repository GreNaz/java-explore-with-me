package ru.practicum.ewm.controller;

import dto.EndpointHitDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.practicum.ewm.controller.client.StatClient;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class StatController {

    private final StatClient client;

    // Сохранение информации о том,
    // что на uri конкретного сервиса был отправлен запрос пользователем.
    // Название сервиса, uri и ip пользователя указаны в теле запроса.
    @PostMapping("/hit")
    public ResponseEntity<Object> save(
            @RequestBody EndpointHitDTO endpointHitDTO) {
        return client.save(endpointHitDTO);
    }

    @GetMapping("/stats")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public ResponseEntity<Object> getStat(
            //Дата и время конца диапазона за который нужно выгрузить статистику (в формате "yyyy-MM-dd HH:mm:ss")
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end,
            // Список uri для которых нужно выгрузить статистику
            @RequestParam(required = false) List<String> uris,
            // Нужно ли учитывать только уникальные посещения (только с уникальным ip)
            @RequestParam(defaultValue = "false") boolean unique) {
        return client.getStat(start, end, uris, unique);
    }
}
