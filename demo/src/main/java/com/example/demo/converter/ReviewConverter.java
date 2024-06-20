package com.example.demo.converter;

import com.example.demo.domain.Review;
import com.example.demo.web.dto.ReviewRequestDTO;
import com.example.demo.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.AddResultDTO toAddResultDTO(Review review) {
        return ReviewResponseDTO.AddResultDTO.builder()
                .createdAt(LocalDateTime.now())
                .reviewId(review.getId())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.AddDTO request) {
        return Review.builder()
                .content(request.getContent())
                .score(request.getScore())
                .build();
    }
}
