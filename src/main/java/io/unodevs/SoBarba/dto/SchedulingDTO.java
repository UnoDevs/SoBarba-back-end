package io.unodevs.SoBarba.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SchedulingDTO implements Serializable {

    private static final long serialVersionUID = 1l;

    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long client_id;
    private Long barber_id;

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

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public Long getBarber_id() {
        return barber_id;
    }

    public void setBarber_id(Long barber_id) {
        this.barber_id = barber_id;
    }
}
