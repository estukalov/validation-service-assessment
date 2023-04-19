package com.estukalov.assessment.controller;

public class Error {
    private final String property;
    private final String message;

    public Error(String property, String message) {
        this.property = property;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getProperty() {
        return property;
    }
}
