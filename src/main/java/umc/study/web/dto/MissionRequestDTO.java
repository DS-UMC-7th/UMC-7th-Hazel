package umc.study.web.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.validation.annotation.ExistMission;
import umc.study.validation.annotation.ExistStore;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class AddMissionDto {

        @ExistStore
        private Long storeId;

        @NotNull(message = "보상 포인트를 작성해 주세요.")
        private Integer reward;

        @Future(message = "마감일은 미래의 날짜여야 합니디.")
        private LocalDate deadline;

        @NotBlank(message = "미션 설명은 필수입니다.")
        private String missionSpec;

    }

    @Getter
    public static class ChallengeMissionDto {

        @NotNull(message = "멤버 ID는 필수")
        private Long memberId;

        @NotNull(message = "미션 ID는 필수")
        @ExistMission
        private Long missionId;
    }
}