package com.estukalov.assessment.controller;

import java.util.ArrayList;
import java.util.List;

public class ErrorContainerResponse {
    private final List<Error> errors = new ArrayList<>();
    public List<Error> getErrors() {
        return errors;
    }
}
