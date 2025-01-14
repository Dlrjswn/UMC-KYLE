package com.example.demo.service.MissionService;

import com.example.demo.apiPayload.code.status.ErrorStatus;
import com.example.demo.apiPayload.exception.handler.MemberHandler;
import com.example.demo.apiPayload.exception.handler.MissionHandler;
import com.example.demo.apiPayload.exception.handler.StoreHandler;
import com.example.demo.converter.MemberMissionConverter;
import com.example.demo.converter.MissionConverter;
import com.example.demo.domain.Member;
import com.example.demo.domain.Mission;
import com.example.demo.domain.Store;
import com.example.demo.domain.mapping.MemberMission;
import com.example.demo.repository.MemberMissionRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MissionRepository;
import com.example.demo.repository.StoreRepository;
import com.example.demo.web.dto.MissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
private final MemberRepository memberRepository;


    @Override
    public Mission addMission(Long storeId, MissionRequestDTO.AddDTO request){
        Mission newMission = MissionConverter.toMission(request);

        Store store = storeRepository.findById(storeId).orElseThrow(()->new StoreHandler(ErrorStatus.STORE_NOT_EXIST));
        newMission.setStore(store);

        return missionRepository.save(newMission);

    }

    @Override
    @Transactional
    public Mission updateMissionStatus(Long memberId, Long missionId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(missionId).orElseThrow(()->new MissionHandler(ErrorStatus.MISSION_NOT_EXIST));

        member.getMemberMissionList().forEach(
                memberMission -> {
                    if (memberMission.getMission().getId() == missionId) {
                        memberMission.changeStatusToComplete();
                    }
                }
        );

        return mission;
    }


}
