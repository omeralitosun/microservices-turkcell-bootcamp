package com.kodlamaio.commonpackage.utils.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotFutureYearValidator.class)
public @interface NotFutureYear {
    String message() default "Model year value cannot be in the future";
    //? Farklı kullanıcı gruplarına özelleştirilmiş ilemler veya özellikler tanımlamak için kullanılır.
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
