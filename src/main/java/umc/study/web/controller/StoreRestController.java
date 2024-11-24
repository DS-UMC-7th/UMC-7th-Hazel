package umc.study.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.domain.Store;
import umc.study.service.StoreService.StoreCommnadService;
import umc.study.web.dto.StoreRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommnadService storeCommnadService;

    @PostMapping("/")
    public ApiResponse<Store> store(@RequestBody @Valid StoreRequestDTO.AddStoreDto request){
        Store response = storeCommnadService.addStore(request);

        return ApiResponse.onSuccess(response);
    }
}
