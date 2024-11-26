package umc.study.service.StoreService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.RegionHandler;
import umc.study.converter.StoreConverter;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.repository.RegionRepository.RegionRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;


@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl extends StoreCommnadService{

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store addStore(StoreRequestDTO.AddStoreDto request){
//        Store newStore = StoreConverter.toStore(request);

        // Region 조회
        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND)); // REGION_NOT_FOUND 예외 처리

        // Store 생성, 연관 설정
        Store store = StoreConverter.toStore(request, region);

        // Store 저장??
//        Store savedStore = storeRepository.save(store);

        return storeRepository.save(store);
    }
}
