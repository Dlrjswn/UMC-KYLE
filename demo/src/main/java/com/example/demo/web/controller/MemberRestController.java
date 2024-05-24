package com.example.demo.web.controller;


import com.example.demo.apiPayload.ApiResponse;
import com.example.demo.converter.MemberConverter;
import com.example.demo.domain.Member;
import com.example.demo.service.MemberService.MemberCommandSerivce;
import com.example.demo.web.dto.MemberResponseDTO;
import com.example.demo.web.dto.MemberRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {
    private final MemberCommandSerivce memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.joinDTO request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
