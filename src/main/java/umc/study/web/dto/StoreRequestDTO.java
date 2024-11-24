package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class StoreRequestDTO {

    @Getter
    @Setter
    public static class AddStoreDto {
        @NotBlank(message = "Store name is required")
        private String name;

        @NotBlank(message = "Address is required")
        private String address;

        @NotNull(message = "Region ID is required")
        private Long regionId;

        private Float score; // Optional
    }
}
