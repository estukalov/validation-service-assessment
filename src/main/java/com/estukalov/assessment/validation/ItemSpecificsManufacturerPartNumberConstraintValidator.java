package com.estukalov.assessment.validation;

import com.estukalov.assessment.domain.Condition;
import com.estukalov.assessment.domain.Item;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ItemSpecificsManufacturerPartNumberConstraintValidator implements ConstraintValidator<ItemSpecificsManufacturerPartNumberConstraint, Item> {
    @Override
    public boolean isValid(Item item, ConstraintValidatorContext context) {
        boolean valid = true;
        if (item.getCondition().equals(Condition.NEW)) {
            if (item.getItemSpecifics().getManufacturerPartNumber() == null || item.getItemSpecifics().getManufacturerPartNumber().isEmpty()) {
                valid = false;
            }
        }
        return valid;
    }
}
