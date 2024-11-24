package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class MissionResponseDTO {
    private Long id;
    private Integer reward;
    private LocalDate deadline;
    private String missionSpec;
    private Long storeId;
}