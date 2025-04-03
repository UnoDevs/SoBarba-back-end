package io.unodevs.SoBarba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double salePrice;

    private boolean isActive;

    private boolean hasStock;

    private double purchasePrice;

    public Product() {

    }

    public Product(Long id, String name, double salePrice, boolean isActive, boolean hasStock, double purchasePrice) {
        this.id = id;
        this.name = name;
        this.salePrice = salePrice;
        this.isActive = isActive;
        this.hasStock = hasStock;
        this.purchasePrice = purchasePrice;
    }

    public Product(String name, double salePrice, boolean isActive, boolean hasStock, double purchasePrice) {
        this.name = name;
        this.salePrice = salePrice;
        this.isActive = isActive;
        this.hasStock = hasStock;
        this.purchasePrice = purchasePrice;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isHasStock() {
        return hasStock;
    }

    public void setHasStock(boolean hasStock) {
        this.hasStock = hasStock;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}
