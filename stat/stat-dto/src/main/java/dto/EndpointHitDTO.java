package dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EndpointHitDTO {
    // Идентификатор записи
    private Integer id;
    // Идентификатор сервиса для которого записывается информация
    private String app;
    // URI для которого был осуществлен запрос
    private String uri;
    // IP-адрес пользователя, осуществившего запрос
    private String ip;
    // Дата и время, когда был совершен запрос к эндпоинту (в формате "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
}
