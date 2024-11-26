package umc.study.service.StoreService;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);

    Page<Review> getReviewList(Long StoreId, Integer page);

    // 9주차 미션 1 - 내가(특정 유저가) 작성한 리뷰 목록 조회
    Page<Review> getReviewByMember(Long memberId, Integer Page);

    // 9주차 미션 2 - 특정 가게의 미션 목록 조회
    Page<Mission> getMissionsByStore(Long storeId, Integer Page);
}