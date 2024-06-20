package com.example.demo.service.StoreService;

import com.example.demo.domain.Review;
import com.example.demo.domain.Store;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;

    private final ReviewRepository reviewRepository;


    @Override
    public Optional<Store> findStore(Long id){
        return storeRepository.findById(id);
    }
    @Override
    public Page<Review> getReviewList(Long storeId, Integer page){
        Store store = storeRepository.findById(storeId).get();

        Page<Review> storePage = reviewRepository.findAllByStore(store, PageRequest.of(page,10));

        return storePage;
    }
}
