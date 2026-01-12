package com.billing.entity;

public class Product {
    private int productId;
    private String name;
    private int price;
    private int gstPercentage;
    private int stockQuantity;

    public Product(int productId, String name, int price, int gstPercentage, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.gstPercentage = gstPercentage;
        this.stockQuantity = stockQuantity;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGstPercentage() {
        return gstPercentage;
    }

    public void setGstPercentage(int gstPercentage) {
        this.gstPercentage = gstPercentage;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
