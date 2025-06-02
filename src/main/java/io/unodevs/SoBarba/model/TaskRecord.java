package io.unodevs.SoBarba.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class TaskRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime movimentDate;
    private Double value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", insertable = false, updatable = false)
    private Task task;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "financial_id", insertable = false, updatable = false)
    private FinancialRecord financialRecord;

    public TaskRecord() {
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

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public FinancialRecord getFinancialRecord() {
        return financialRecord;
    }

    public void setFinancialRecord(FinancialRecord financialRecord) {
        this.financialRecord = financialRecord;
    }
}
