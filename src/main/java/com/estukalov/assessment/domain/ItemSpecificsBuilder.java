package com.estukalov.assessment.domain;

public class ItemSpecificsBuilder {
    private String type;
    private String manufacturerPartNumber;

    public ItemSpecificsBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public ItemSpecificsBuilder setManufacturerPartNumber(String manufacturerPartNumber) {
        this.manufacturerPartNumber = manufacturerPartNumber;
        return this;
    }

    public ItemSpecifics createItemSpecifics() {
        return new ItemSpecifics(type, manufacturerPartNumber);
    }
}