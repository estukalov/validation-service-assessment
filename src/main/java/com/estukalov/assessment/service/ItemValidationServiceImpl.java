package com.estukalov.assessment.service;

import com.estukalov.assessment.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

@Service
public class ItemValidationServiceImpl implements ItemValidationService {
    @Autowired
    private Validator validator;

    @Override
    public void validate(Item item) {

        Set<ConstraintViolation<Item>> constraintViolations = validator.validate(item);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }
}
