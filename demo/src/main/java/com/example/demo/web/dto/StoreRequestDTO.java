package com.example.demo.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class AddDTO {

        @NotNull
        String name;
        @NotNull
        String address;
        @NotNull
        Float score;

    }
}
