package io.unodevs.SoBarba.model;

import io.unodevs.SoBarba.model.enumerator.FinancialStatus;
import io.unodevs.SoBarba.model.enumerator.FinancialType;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class FinancialRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double value;

    @Enumerated(EnumType.STRING)
    private FinancialType type;

    @Enumerated(EnumType.STRING)
    private FinancialStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private Person client;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "barber_id")
    private Person barber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "scheduling_id", referencedColumnName = "id")
    private Scheduling scheduling;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "financial_id")
    private List<TaskRecord> taskRecords;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "financial_id")
    private List<ProductRecord> productRecords;


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

    public Scheduling getScheduling() {
        return scheduling;
    }

    public void setScheduling(Scheduling scheduling) {
        this.scheduling = scheduling;
    }

    public List<TaskRecord> getTaskRecords() {
        return taskRecords;
    }

    public void setTaskRecords(List<TaskRecord> taskRecords) {
        this.taskRecords = taskRecords;
    }

    public void addTaskRecords(TaskRecord taskRecord){
        this.taskRecords.add(taskRecord);
        taskRecord.setFinancialRecord(this);
    }
    public void removeTaskRecords(TaskRecord taskRecord){this.taskRecords.remove(taskRecord);}

    public List<ProductRecord> getProductRecords() {
        return productRecords;
    }

    public void setProductRecords(List<ProductRecord> productRecords) {
        this.productRecords = productRecords;
    }

    public void addProductRecords(ProductRecord productRecord){
        this.productRecords.add(productRecord);
        productRecord.setFinancialRecord(this);
    }
    public void removeProductRecords(ProductRecord productRecord){this.productRecords.remove(productRecord);}
}
