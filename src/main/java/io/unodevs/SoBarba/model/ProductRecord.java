package io.unodevs.SoBarba.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ProductRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime movimentDate;
    private Double quantity;
    private Double value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "financial_id", insertable = false, updatable = false)
    private FinancialRecord financialRecord;

    public ProductRecord() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getMovimentDate() {
        return movimentDate;
    }

    public void setMovimentDate(LocalDateTime movimentDate) {
        this.movimentDate = movimentDate;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public FinancialRecord getFinancialRecord() {
        return financialRecord;
    }

    public void setFinancialRecord(FinancialRecord financialRecord) {
        this.financialRecord = financialRecord;
    }
}
