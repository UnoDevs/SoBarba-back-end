package io.unodevs.SoBarba.dto;

import io.unodevs.SoBarba.model.enumerator.FinancialStatus;
import io.unodevs.SoBarba.model.enumerator.FinancialType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class FinancialRecordDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Double value;
    private LocalDate issueDate;
    private FinancialType type;
    private FinancialStatus status;
    private Long clientId;
    private Long barber;
    private Long scheduling;
    private List<ProductRecordDTO> products;
    private List<TaskRecordDTO> tasks;

    public FinancialRecordDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public FinancialType getType() {
        return type;
    }

    public void setType(FinancialType type) {
        this.type = type;
    }

    public FinancialStatus getStatus() {
        return status;
    }

    public void setStatus(FinancialStatus status) {
        this.status = status;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getBarber() {
        return barber;
    }

    public void setBarber(Long barber) {
        this.barber = barber;
    }

    public Long getScheduling() {
        return scheduling;
    }

    public void setScheduling(Long scheduling) {
        this.scheduling = scheduling;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public List<ProductRecordDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductRecordDTO> products) {
        this.products = products;
    }

    public List<TaskRecordDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskRecordDTO> tasks) {
        this.tasks = tasks;
    }
}
