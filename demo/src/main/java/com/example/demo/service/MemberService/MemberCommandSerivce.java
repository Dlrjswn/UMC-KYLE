package com.example.demo.service.MemberService;

import com.example.demo.domain.Member;
import com.example.demo.web.dto.MemberRequestDTO;

public interface MemberCommandSerivce {
    public Member joinMember(MemberRequestDTO.joinDTO request);
    public boolean foodType_existsById(Long id);


}
