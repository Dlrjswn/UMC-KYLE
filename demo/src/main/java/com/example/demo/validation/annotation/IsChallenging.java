package com.example.demo.validation.annotation;


import com.example.demo.validation.validator.CategoriesExistValidator;
import com.example.demo.validation.validator.ChallengingValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ChallengingValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsChallenging {

    String message() default "해당 미션은 이미 도전중입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}