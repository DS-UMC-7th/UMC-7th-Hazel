package umc.study.service.StoreService;

import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

public abstract class StoreCommnadService {
    public abstract Store addStore(StoreRequestDTO.AddStoreDto request);
}
