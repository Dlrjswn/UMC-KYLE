package com.example.demo.service.ReviewService;


import com.example.demo.domain.Review;
import com.example.demo.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    public Review addReview(Long storeId, Long memberId, ReviewRequestDTO.AddDTO request);
}

