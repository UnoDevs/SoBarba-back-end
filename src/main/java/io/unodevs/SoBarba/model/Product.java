package io.unodevs.SoBarba.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double salePrice;

    private Boolean active;

    private Boolean hasStock;

    private Double purchasePrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private Category category;

    public Product() {

    }

    public Product(String name, double salePrice, boolean active, boolean hasStock, double purchasePrice) {
        this.name = name;
        this.salePrice = salePrice;
        this.active = active;
        this.hasStock = hasStock;
        this.purchasePrice = purchasePrice;
    }

    public Product(Long id, String name, double salePrice, boolean active, boolean hasStock, double purchasePrice) {
        this.id = id;
        this.name = name;
        this.salePrice = salePrice;
        this.active = active;
        this.hasStock = hasStock;
        this.purchasePrice = purchasePrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getHasStock() {
        return hasStock;
    }

    public void setHasStock(Boolean hasStock) {
        this.hasStock = hasStock;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(salePrice, product.salePrice) && Objects.equals(active, product.active) && Objects.equals(hasStock, product.hasStock) && Objects.equals(purchasePrice, product.purchasePrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salePrice, active, hasStock, purchasePrice);
    }
}
