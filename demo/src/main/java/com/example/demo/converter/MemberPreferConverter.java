package com.example.demo.converter;

import com.example.demo.domain.FoodType;
import com.example.demo.domain.mapping.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {
    public static List<MemberPrefer> toMemberPreferList(List<FoodType> foodTypeList) {

        return foodTypeList.stream()
                .map(foodType ->
                        MemberPrefer.builder()
                                .foodType(foodType)
                                .build()
                ).collect(Collectors.toList());
    }
}
