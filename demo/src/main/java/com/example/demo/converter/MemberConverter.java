package com.example.demo.converter;

import com.example.demo.domain.Member;
import com.example.demo.domain.enums.Gender;
import com.example.demo.web.dto.MemberRequestDTO;
import com.example.demo.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

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



}
