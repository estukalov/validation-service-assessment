package com.estukalov.assessment.domain;

public class ItemSpecifics {
    private String type;
    private String manufacturerPartNumber;

    public ItemSpecifics(String type, String manufacturerPartNumber) {
        this.type = type;
        this.manufacturerPartNumber = manufacturerPartNumber;
    }

    public String getType() {
        return type;
    }

    public String getManufacturerPartNumber() {
        return manufacturerPartNumber;
    }

    public void setManufacturerPartNumber(String manufacturerPartNumber) {
        this.manufacturerPartNumber = manufacturerPartNumber;
    }

    public void setType(String type) {
        this.type = type;
    }
}
