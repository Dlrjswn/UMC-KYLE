package com.example.demo.converter;

import com.example.demo.domain.Member;
import com.example.demo.domain.Mission;
import com.example.demo.domain.Review;
import com.example.demo.domain.enums.Gender;
import com.example.demo.domain.enums.MissionStatus;
import com.example.demo.web.dto.*;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.joinDTO request) {

        Gender gender = null;
        switch (request.getGender()){
            case 1 : gender = Gender.MALE;
            break;
            case 2 : gender = Gender.FEMALE;
            break;
        }
        return Member.builder()
                .address(request.getAddress())
                .name(request.getName())
                .gender(gender)
                .phoneNum(request.getPhoneNumber())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static Review toReview(MemberRequestDTO.ReviewDTO request){
        return Review.builder()
                .content(request.getContent())
                .score(request.getScore())
                .build();
    }

    public static MemberResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review){
        return MemberResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return MemberResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .content(review.getContent())
                .build();
    }

    public static MemberResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<MemberResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(MemberConverter::reviewPreViewDTO).collect(Collectors.toList());

        return MemberResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static MissionResponseDTO.FindMissionsDto toFindMissionDto(Member member, Integer value) {

        MissionStatus status=null;
        switch (value) {
            case 0:
                status = MissionStatus.CHALLENGING;
                break;
            case 1:
                status = MissionStatus.COMPLETE;
                break;
        }

        MissionStatus finalStatus = status;
        List<MissionResponseDTO.FindMissionsDto.MissionsMeta> missions = member.getMemberMissionList().stream()
                .filter(memberMission -> memberMission.getStatus() == finalStatus)
                .map(membermission -> MissionResponseDTO.FindMissionsDto.MissionsMeta.builder()
                        .storeName(membermission.getMission().getStore().getName())
                        .content(membermission.getMission().getContent())
                        .status(membermission.getStatus())
                        .reward(membermission.getMission().getReward())
                        .build())
                .collect(Collectors.toList());

        return MissionResponseDTO.FindMissionsDto.builder()
                .missions(missions)
                .build();
    }


}
