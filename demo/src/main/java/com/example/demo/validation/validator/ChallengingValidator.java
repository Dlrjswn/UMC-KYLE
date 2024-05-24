package com.example.demo.validation.validator;

import com.example.demo.apiPayload.code.status.ErrorStatus;
import com.example.demo.apiPayload.exception.handler.StoreHandler;
import com.example.demo.domain.Mission;
import com.example.demo.domain.Store;
import com.example.demo.domain.enums.MissionStatus;
import com.example.demo.domain.mapping.MemberMission;
import com.example.demo.repository.MemberMissionRepository;
import com.example.demo.repository.MissionRepository;
import com.example.demo.repository.StoreRepository;
import com.example.demo.validation.annotation.ExistStore;
import com.example.demo.validation.annotation.IsChallenging;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class ChallengingValidator implements ConstraintValidator<IsChallenging, Long> {


    private final StoreRepository storeRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public void initialize(IsChallenging constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long values, ConstraintValidatorContext context) {
        boolean isValid;
        MissionStatus missionStatus = memberMissionRepository.getReferenceById(values).getStatus();
        isValid= missionStatus != MissionStatus.CHALLENGING;

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_IS_CHALLENGING.toString()).addConstraintViolation();
        }

        return isValid;

    }
}
