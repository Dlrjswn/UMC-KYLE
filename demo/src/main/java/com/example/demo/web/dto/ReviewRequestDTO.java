package com.example.demo.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class AddDTO{
  @NotNull
  String content;

  @NotNull
 Float score;

    }
}
