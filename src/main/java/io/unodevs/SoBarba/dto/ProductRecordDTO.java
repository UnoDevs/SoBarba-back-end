package io.unodevs.SoBarba.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ProductRecordDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private LocalDateTime movimentDate;
    private Double value;
    private Double quantity;
    private Long productId;
    private Long financialId;

    public ProductRecordDTO() {
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getFinancialId() {
        return financialId;
    }

    public void setFinancialId(Long financialId) {
        this.financialId = financialId;
    }
}
