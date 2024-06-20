package com.example.demo.web.controller;


import com.example.demo.apiPayload.ApiResponse;
import com.example.demo.converter.ReviewConverter;
import com.example.demo.domain.Review;
import com.example.demo.service.ReviewService.ReviewCommandService;
import com.example.demo.validation.annotation.ExistStore;
import com.example.demo.web.dto.ReviewRequestDTO;
import com.example.demo.web.dto.ReviewResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews/{membersid}/members")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.AddResultDTO> addReview(@RequestParam("storesid") @ExistStore Long storeId, @PathVariable("membersid") Long memberId, @RequestBody @Valid ReviewRequestDTO.AddDTO request) {
Review review = reviewCommandService.addReview(storeId, memberId, request);
return ApiResponse.onSuccess(ReviewConverter.toAddResultDTO(review));
    }

}
