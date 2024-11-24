package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

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
}
