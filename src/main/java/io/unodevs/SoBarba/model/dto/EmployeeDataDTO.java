package io.unodevs.SoBarba.model.dto;

import io.unodevs.SoBarba.model.enumerator.JobTitleType;

import java.io.Serializable;
import java.time.LocalDate;

public class EmployeeDataDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private LocalDate hireDate;
    private LocalDate terminationDate;
    private Double salary;
    private Double commission;
    private JobTitleType jobTitle;

    public EmployeeDataDTO() {
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
}
