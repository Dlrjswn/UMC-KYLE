package com.example.demo.validation.validator;

import com.example.demo.apiPayload.code.status.ErrorStatus;
import com.example.demo.service.StoreService.StoreCommandService;
import com.example.demo.validation.annotation.ExistStore;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;




@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator <ExistStore,Long> {

    private final StoreCommandService storeCommandService;

    @Override
    public void initialize(ExistStore constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long values, ConstraintValidatorContext context) {
        boolean isValid = storeCommandService.existsById(values);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_EXIST.toString()).addConstraintViolation();
        }

        return isValid;

    }
}
