package io.unodevs.SoBarba.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Double salePrice;
    private Boolean active = true;
    private Boolean hasStock;
    private Double purchasePrice;
    private Long categoryId;

    public ProductDTO() {
    }

    public ProductDTO(String name, Double salePrice, Boolean active, Boolean hasStock, Double purchasePrice) {
        this.name = name;
        this.salePrice = salePrice;
        this.active = active;
        this.hasStock = hasStock;
        this.purchasePrice = purchasePrice;
    }

    public ProductDTO(Long id, String name, Double salePrice, Boolean active, Boolean hasStock, Double purchasePrice) {
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(salePrice, that.salePrice) && Objects.equals(active, that.active) && Objects.equals(hasStock, that.hasStock) && Objects.equals(purchasePrice, that.purchasePrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salePrice, active, hasStock, purchasePrice);
    }
}
