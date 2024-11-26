package umc.study.converter;

import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.AddReviewDto request, Store store) {
        return Review.builder()
                .store(store)
                .title(request.getTitle())
                .body(request.getBody())
                .score(request.getScore())
                .memberId(request.getMemberId())
                .build();
    }

    public static ReviewResponseDTO.ReviewInfoDTO toReviewInfoDTO(Review review) {
        return ReviewResponseDTO.ReviewInfoDTO.builder()
                .id(review.getId())
                .title(review.getTitle())
                .body(review.getBody())
                .score(review.getScore())
                .storeName(review.getStore().getName())
                .memberId(review.getMemberId())
                .createdAt(review.getCreatedAt())
                .build();
    }
}

