package umc.study.web.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import umc.study.validation.annotation.ExistStore;

public class ReviewRequestDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddReviewDto {

//        @NotNull(message = "가게 ID는 필수입니다.")
        @ExistStore // 커스텀 어노테이션 (리뷰를 작성하려는 가게가 존재하는지 검증)
        private Long storeId;

        @NotBlank(message = "리뷰 제목은 필수입니다.")
        @Size(max = 100, message = "리뷰 제목은 최대 100자까지 가능합니다.")
        private String title;

        @NotBlank(message = "리뷰 본문은 필수입니다.")
        private String body;

        @NotNull(message = "평점은 필수입니다.")
        @Min(value = 1, message = "평점은 최소 1점 이상이어야 합니다.")
        @Max(value = 5, message = "평점은 최대 5점 이하이어야 합니다.")
        private Float score;

        @NotNull(message = "회원 ID는 필수입니다.")
        private Long memberId;
    }
}

