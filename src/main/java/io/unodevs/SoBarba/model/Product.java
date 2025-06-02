package io.unodevs.SoBarba.model;

import jakarta.persistence.*;

import java.util.List;
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<ProductRecord> productRecords;

    public Product() {}

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

    public List<ProductRecord> getProductRecords() {
        return productRecords;
    }

    public void addProductRecords(ProductRecord productRecord){
        this.productRecords.add(productRecord);
        productRecord.setProduct(this);
    }

    public void removeTaskRecords(ProductRecord productRecord){this.productRecords.remove(productRecord);}

    public void setProductRecords(List<ProductRecord> productRecords) {
        this.productRecords = productRecords;
    }
}
