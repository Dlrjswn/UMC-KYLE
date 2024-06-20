package com.example.demo.converter;

import com.example.demo.domain.Mission;
import com.example.demo.web.dto.MissionRequestDTO;
import com.example.demo.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static Mission toMission (MissionRequestDTO.AddDTO request){
        return Mission.builder()
                .content(request.getContent())
                .reward(request.getReward())
                .build();

    }

    public static MissionResponseDTO.AddResultDTO toAddResultDTO (Mission mission){
        return MissionResponseDTO.AddResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MissionResponseDTO.UpdateResultDTO toUpdateResultDTO (Mission mission){
        return MissionResponseDTO.UpdateResultDTO.builder()
                .missionId(mission.getId())
                .updatedAt(LocalDateTime.now())
                .build();
    }
    public static MissionResponseDTO.UpdateMissionStatusDto updateMissionStatusDto(Mission mission) {
        return MissionResponseDTO.UpdateMissionStatusDto.builder()
                .missionId(mission.getId())
                .updatedAt(mission.getUpdatedAt())
                .build();
    }
}
