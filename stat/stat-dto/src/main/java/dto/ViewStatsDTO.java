package dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ViewStatsDTO {
    private String app; // Название сервиса
    private String uri; // URI сервиса
    private Integer hits; // Количество просмотров
}
