package umc.study.converter;

import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

public class StoreConverter {

    public static StoreResponseDTO.StoreInfoDTO toStoreInfoDTO(Store store, Region region) {
        return StoreResponseDTO.StoreInfoDTO.builder()
                .storeId(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .score(store.getScore())
                .regionName(region.getName())
                .build();
    }

    public static Store toStore(StoreRequestDTO.AddStoreDto request, Region region) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score(request.getScore() != null ? request.getScore() : 0.0f) // Default score
                .region(region)
                .build();
    }
}
