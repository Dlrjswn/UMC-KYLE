package com.example.demo.service.MemberService;

import com.example.demo.domain.Member;
import com.example.demo.domain.Review;
import com.example.demo.domain.Store;
import com.example.demo.web.dto.MissionResponseDTO;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface MemberQueryService {
    Optional<Member> findMember(Long id);

    Page<Review> getReviewList(Long memberId, Integer page);
    MissionResponseDTO.FindMissionsDto findMissions(Long memberId, Integer status);
}
