package com.example.demo.web.dto;

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
