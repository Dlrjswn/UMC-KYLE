package com.example.demo.web.dto;

import com.example.demo.validation.annotation.ExistCategories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class joinDTO{
        @NotBlank
        String name;

        @NotNull
        int gender;
        @NotNull
        String address;
        @NotNull
        String email;
        @NotNull
        String phoneNumber;
        @ExistCategories
        List<Long> preferType;

    }
}