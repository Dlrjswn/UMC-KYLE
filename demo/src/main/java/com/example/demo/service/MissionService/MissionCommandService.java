package com.example.demo.service.MissionService;

import com.example.demo.domain.Mission;
import com.example.demo.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    public Mission addMission(Long storeId, MissionRequestDTO.AddDTO request);
}

