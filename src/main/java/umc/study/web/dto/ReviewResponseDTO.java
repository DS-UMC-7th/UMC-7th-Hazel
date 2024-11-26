package umc.study.web.dto;

import lombok.*;

import java.time.LocalDateTime;

public class ReviewResponseDTO {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewInfoDTO {
        private Long id;
        private String title;
        private String body;
        private Float score;
        private String storeName;
        private Long memberId;
        private LocalDateTime createdAt;
    }
}