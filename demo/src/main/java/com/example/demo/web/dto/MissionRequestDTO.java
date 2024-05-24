package com.example.demo.web.dto;

import com.example.demo.validation.annotation.IsChallenging;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MissionRequestDTO {

    @Getter
    public static class AddDTO{

        @NotNull
        String content;

        @NotNull
        int reward;

    }


    @Getter
    public static class UpdateDTO{

        @NotNull
        int status;
    }
}
