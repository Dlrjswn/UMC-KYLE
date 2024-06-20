package com.example.demo.web.controller;


import com.example.demo.apiPayload.ApiResponse;
import com.example.demo.converter.MissionConverter;
import com.example.demo.domain.Member;
import com.example.demo.domain.Mission;
import com.example.demo.service.MemberMissionService.MemberMissionCommandService;
import com.example.demo.service.MissionService.MissionCommandService;
import com.example.demo.validation.annotation.ExistStore;
import com.example.demo.web.dto.MissionRequestDTO;
import com.example.demo.web.dto.MissionResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/{storesid}/stores")
    public ApiResponse<MissionResponseDTO.AddResultDTO> addMission(@PathVariable("storesid") @ExistStore Long storeId, @RequestBody @Valid MissionRequestDTO.AddDTO request) {
        Mission mission = missionCommandService.addMission(storeId, request);

        return ApiResponse.onSuccess(MissionConverter.toAddResultDTO(mission));
    }

    @PutMapping("/{storesid}/stores")
    public ApiResponse<MissionResponseDTO.UpdateResultDTO> updateMission(@PathVariable("storesid") @ExistStore Long storeId, @RequestParam("membersid") Long memberId, @RequestBody @Valid MissionRequestDTO.UpdateDTO request) {
        Mission mission = memberMissionCommandService.updateMemberMissionStatus(storeId,memberId, request);
        return ApiResponse.onSuccess(MissionConverter.toUpdateResultDTO(mission));
    }


    @PatchMapping("/{memberId}/{missionId}")
    @Operation(summary = "특정 멤버의 미션 상태 변경 API",description = "특정 멤버의 미션 상태를 변경하는 API입니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "멤버의 아이디, path variable 입니다!"),
            @Parameter(name = "missionId", description = "미션의 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionResponseDTO.UpdateMissionStatusDto> updateMissionStatus( @PathVariable(name = "memberId") Long memberId,
                                                                                       @PathVariable(name = "missionId") Long missionId) {
        Mission mission = missionCommandService.updateMissionStatus(memberId, missionId);
        return ApiResponse.onSuccess(MissionConverter.updateMissionStatusDto(mission));
    }

}
