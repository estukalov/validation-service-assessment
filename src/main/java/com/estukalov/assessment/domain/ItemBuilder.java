package com.estukalov.assessment.domain;

import java.net.URL;
import java.util.List;

public class ItemBuilder {
    private int siteId;
    private long categoryId;
    private String title;
    private Condition condition;
    private float price;
    private int quantity;
    private List<URL> imageUrls;
    private ItemSpecifics itemSpecifics;
    private String description;

    public ItemBuilder setSiteId(int siteId) {
        this.siteId = siteId;
        return this;
    }

    public ItemBuilder setCategoryId(long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public ItemBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public ItemBuilder setCondition(Condition condition) {
        this.condition = condition;
        return this;
    }

    public ItemBuilder setPrice(float price) {
        this.price = price;
        return this;
    }

    public ItemBuilder setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public ItemBuilder setImageUrls(List<URL> imageUrls) {
        this.imageUrls = imageUrls;
        return this;
    }

    public ItemBuilder setItemSpecifics(ItemSpecifics itemSpecifics) {
        this.itemSpecifics = itemSpecifics;
        return this;
    }

    public ItemBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public Item createItem() {
        return new Item(siteId, categoryId, title, condition, price, quantity, imageUrls, itemSpecifics, description);
    }
}