package com.example.demo.service.MemberMissionService;

import com.example.demo.apiPayload.code.status.ErrorStatus;
import com.example.demo.apiPayload.exception.handler.MemberHandler;
import com.example.demo.apiPayload.exception.handler.StoreHandler;
import com.example.demo.converter.MemberMissionConverter;
import com.example.demo.domain.Member;
import com.example.demo.domain.Mission;
import com.example.demo.domain.Store;
import com.example.demo.domain.mapping.MemberMission;
import com.example.demo.repository.MemberMissionRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.StoreRepository;
import com.example.demo.web.dto.MissionRequestDTO;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {


    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    public Mission updateMemberMissionStatus(Long storeId, Long memberId, MissionRequestDTO.UpdateDTO request){
        MemberMission newMemberMission = MemberMissionConverter.toMemberMission(request);
        Store store = storeRepository.findById(storeId).orElseThrow(()-> new StoreHandler(ErrorStatus.STORE_NOT_EXIST));
        Mission mission = store.getMission();
        Member member = memberRepository.findById(memberId).orElseThrow (()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));


        //미션이랑 멤버미션이랑 멤버 연결.
        newMemberMission.setMember(member);
        newMemberMission.setMission(mission);

        memberMissionRepository.save(newMemberMission);


        return mission;
    }
}
