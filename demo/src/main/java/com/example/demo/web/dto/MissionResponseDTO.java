package com.example.demo.web.dto;

import com.example.demo.domain.enums.MissionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDTO {


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddResultDTO{
        Long missionId;
        LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateResultDTO{
        Long missionId;
        LocalDateTime updatedAt;

    }


    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class FindMissionsDto{
        private List<MissionsMeta> missions;

        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        @Getter
        public static class MissionsMeta {
            private String storeName;
            private String content;
            private MissionStatus status;
            private Integer reward;
        }
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class RegisterResultDto{
        private Long missionId;
        private LocalDateTime createAt;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class UpdateMissionStatusDto {
        private Long missionId;
        private LocalDateTime updatedAt;
    }

}
