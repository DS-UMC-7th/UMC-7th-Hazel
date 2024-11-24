package umc.study.service.ReviewService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandService {

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public Review addReview(ReviewRequestDTO.AddReviewDto request) {
        // 가게 존재 여부 확인
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new EntityNotFoundException("가게를 찾을 수 없습니다."));

        // 리뷰 저장
        Review review = ReviewConverter.toReview(request, store);
        return reviewRepository.save(review);
    }
}
