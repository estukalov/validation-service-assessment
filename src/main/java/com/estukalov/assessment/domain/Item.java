package com.estukalov.assessment.domain;

import com.estukalov.assessment.validation.ItemSpecificsManufacturerPartNumberConstraint;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.net.URL;
import java.util.List;

@ItemSpecificsManufacturerPartNumberConstraint
public class Item {
    private final int siteId;
    private final long categoryId;

    @NotNull
    @NotBlank
    private String title;

    private Condition condition;
    private final float price;
    private final int quantity;
    private final List<URL> imageUrls;
    private final ItemSpecifics itemSpecifics;
    private final String description;

    public Item(int siteId, long categoryId, String title, Condition condition, float price, int quantity, List<URL> imageUrls, ItemSpecifics itemSpecifics, String description) {
        this.siteId = siteId;
        this.categoryId = categoryId;
        this.title = title;
        this.condition = condition;
        this.price = price;
        this.quantity = quantity;
        this.imageUrls = imageUrls;
        this.itemSpecifics = itemSpecifics;
        this.description = description;
    }

    public int getSiteId() {
        return siteId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<URL> getImageUrls() {
        return imageUrls;
    }

    public ItemSpecifics getItemSpecifics() {
        return itemSpecifics;
    }
    public String getDescription() {
        return description;
    }
}
