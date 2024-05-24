package com.example.demo.web.controller;


import com.example.demo.apiPayload.ApiResponse;
import com.example.demo.converter.MissionConverter;
import com.example.demo.domain.Mission;
import com.example.demo.service.MemberMissionService.MemberMissionCommandService;
import com.example.demo.service.MissionService.MissionCommandService;
import com.example.demo.validation.annotation.ExistStore;
import com.example.demo.validation.annotation.IsChallenging;
import com.example.demo.web.dto.MissionRequestDTO;
import com.example.demo.web.dto.MissionResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores/{storesid}/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.AddResultDTO> addMission(@PathVariable("storesid") @ExistStore Long storeId, @RequestBody @Valid MissionRequestDTO.AddDTO request) {
        Mission mission = missionCommandService.addMission(storeId, request);

        return ApiResponse.onSuccess(MissionConverter.toAddResultDTO(mission));
    }

    @PutMapping("/")
    public ApiResponse<MissionResponseDTO.UpdateResultDTO> updateMission(@PathVariable("storesid") @ExistStore Long storeId, @RequestParam("membersid") Long memberId, @RequestBody @Valid MissionRequestDTO.UpdateDTO request) {
        Mission mission = memberMissionCommandService.updateMemberMissionStatus(storeId,memberId, request);
        return ApiResponse.onSuccess(MissionConverter.toUpdateResultDTO(mission));
    }

}
