package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public class StoreResponseDTO {

    @Builder
    @Getter
    public static class StoreInfoDTO {
        private Long storeId;
        private String name;
        private String address;
        private Float score;
        private String regionName;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewListDTO {
        List<ReviewPreViewDTO> reviewList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewDTO {
        String ownerNickname;
        Float score;
        String body;
        LocalDate createdAt;
    }

    // 미션
    @Builder
    @Getter
    public static class MissionPreViewDTO {
        private Long id;
        private Integer reward;
        private LocalDate deadline;
        private String missionSpec;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreViewListDTO {
        private List<MissionPreViewDTO> missions;
        private int totalPages;
        private int currentPage;
        private int pageSize;
        private long totalElements;
    }
}
