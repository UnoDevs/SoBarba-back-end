package io.unodevs.SoBarba.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Scheduling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private Person client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "barber_id", insertable = false, updatable = false)
    private Person barber;

    @OneToOne(mappedBy = "scheduling")
    private FinancialRecord financialRecord;

    public Scheduling() {
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

    public Person getClient() {
        return client;
    }

    public void setClient(Person client) {
        this.client = client;
    }

    public Person getBarber() {
        return barber;
    }

    public void setBarber(Person barber) {
        this.barber = barber;
    }

    public FinancialRecord getFinancialRecord() {
        return financialRecord;
    }

    public void setFinancialRecord(FinancialRecord financialRecord) {
        this.financialRecord = financialRecord;
    }
}
