package com.example.demo.converter;

import com.example.demo.domain.Mission;
import com.example.demo.domain.enums.MemberStatus;
import com.example.demo.domain.enums.MissionStatus;
import com.example.demo.domain.mapping.MemberMission;
import com.example.demo.web.dto.MissionRequestDTO;
import com.example.demo.web.dto.MissionResponseDTO;

public class MemberMissionConverter {

    public static MemberMission toMemberMission(MissionRequestDTO.UpdateDTO request) {
        MissionStatus missionStatus;
        switch (request.getStatus()) {
            case 1:
                missionStatus = MissionStatus.CHALLENGING;
                break;
            case 2:
                missionStatus = MissionStatus.COMPLETE;
                break;
            default:
                missionStatus = MissionStatus.NON;
        }
        return MemberMission.builder()
                .status(missionStatus)
                .build();
    }

}

