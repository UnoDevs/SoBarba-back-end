package io.unodevs.SoBarba.model;

import io.unodevs.SoBarba.model.enumerator.JobTitleType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class EmployeeData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate hireDate;
    private LocalDate terminationDate;
    private Double salary;
    private Double commission;
    private JobTitleType jobTitle;
    @OneToOne(mappedBy = "employeeData")
    private Person person;

    public EmployeeData() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDate getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(LocalDate terminationDate) {
        this.terminationDate = terminationDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public JobTitleType getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitleType jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
