package com.example.demo.service.ReviewService;

import com.example.demo.apiPayload.code.status.ErrorStatus;
import com.example.demo.apiPayload.exception.handler.MemberHandler;
import com.example.demo.apiPayload.exception.handler.StoreHandler;
import com.example.demo.converter.ReviewConverter;
import com.example.demo.domain.Member;
import com.example.demo.domain.Review;
import com.example.demo.domain.Store;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.repository.StoreRepository;
import com.example.demo.web.dto.ReviewRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;

    public Review addReview(Long storeId, Long memberId, ReviewRequestDTO.AddDTO request){
        Review newReview = ReviewConverter.toReview(request);
        //member랑 연결, store랑 연결.
        Member member = memberRepository.findById(memberId).orElseThrow(()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Store store = storeRepository.findById(storeId).orElseThrow(()-> new StoreHandler(ErrorStatus.STORE_NOT_EXIST));


        // 편의 메서드
        newReview.setStore(store);
        newReview.setMember(member);

        return reviewRepository.save(newReview);



    }
}
