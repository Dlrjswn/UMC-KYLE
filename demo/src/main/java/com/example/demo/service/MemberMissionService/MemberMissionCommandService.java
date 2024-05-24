package com.example.demo.service.MemberMissionService;

import com.example.demo.domain.Mission;
import com.example.demo.web.dto.MissionRequestDTO;

public interface MemberMissionCommandService {
    public Mission updateMemberMissionStatus(Long storeId, Long memberId, MissionRequestDTO.UpdateDTO request);
}

