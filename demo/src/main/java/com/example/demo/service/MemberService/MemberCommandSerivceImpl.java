package com.example.demo.service.MemberService;


import com.example.demo.apiPayload.code.status.ErrorStatus;
import com.example.demo.apiPayload.exception.handler.FoodTypeHandler;
import com.example.demo.converter.MemberConverter;
import com.example.demo.converter.MemberPreferConverter;
import com.example.demo.domain.FoodType;
import com.example.demo.domain.Member;
import com.example.demo.domain.mapping.MemberPrefer;
import com.example.demo.repository.FoodTypeRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.web.dto.MemberRequestDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandSerivceImpl implements MemberCommandSerivce{

    private final MemberRepository memberRepository;
    private final FoodTypeRepository foodTypeRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.joinDTO request){
        Member newMember = MemberConverter.toMember(request);
        List<FoodType> foodTypeList = request.getPreferType().stream()
                .map(type -> {
                    return foodTypeRepository.findById(type).orElseThrow(()-> new FoodTypeHandler(ErrorStatus.FOOD_TYPE_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodTypeList);
        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});
        return memberRepository.save(newMember);
    }

    public boolean foodType_existsById(Long id){
        return foodTypeRepository.existsById(id);
    }
}
