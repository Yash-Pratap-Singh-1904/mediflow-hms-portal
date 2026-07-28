package com.hms.model;

import java.io.Serializable;

public class Medicine implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String id;
    private final String name;
    private int stockQuantity;
    private double unitPrice;

    public Medicine(String id, String name, int stockQuantity, double unitPrice) {
        this.id = id;
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.unitPrice = unitPrice;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }
    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }
}
