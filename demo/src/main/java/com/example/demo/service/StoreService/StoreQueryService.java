package com.example.demo.service.StoreService;

import com.example.demo.domain.Review;
import com.example.demo.domain.Store;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);

    Page<Review> getReviewList(Long storeId, Integer page);
}
