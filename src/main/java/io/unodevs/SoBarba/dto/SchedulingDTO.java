package io.unodevs.SoBarba.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SchedulingDTO implements Serializable {

    private static final long serialVersionUID = 1l;

    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long clientId;
    private Long barberId;

    public SchedulingDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getBarberId() {
        return barberId;
    }

    public void setBarberId(Long barberId) {
        this.barberId = barberId;
    }
}
