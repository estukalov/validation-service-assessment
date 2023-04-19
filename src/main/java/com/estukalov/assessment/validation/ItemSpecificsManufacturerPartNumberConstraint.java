package com.estukalov.assessment.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ItemSpecificsManufacturerPartNumberConstraintValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ItemSpecificsManufacturerPartNumberConstraint {
    String message() default "Manufacturer Part Number is null for a new item";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
