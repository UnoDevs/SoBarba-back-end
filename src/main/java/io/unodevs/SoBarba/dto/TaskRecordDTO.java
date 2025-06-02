package io.unodevs.SoBarba.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TaskRecordDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private LocalDateTime movimentDate;
    private Double value;
    private Long taskId;
    private Long financialId;

    public TaskRecordDTO() {
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

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getFinancialId() {
        return financialId;
    }

    public void setFinancialId(Long financialId) {
        this.financialId = financialId;
    }


}
