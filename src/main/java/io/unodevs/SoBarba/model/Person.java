package io.unodevs.SoBarba.model;

import io.unodevs.SoBarba.model.enumerator.PersonType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String email;
    private String phone;
    private Boolean active;
    private String document;

    @ElementCollection(targetClass = PersonType.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "PERSONTYPES_PERSON_RELATION", joinColumns = @JoinColumn(name = "person_id"))
    @Column(name = "person_type")
    private List<PersonType> personTypes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_data_id", referencedColumnName = "id")
    private EmployeeData employeeData;

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public List<PersonType> getPersonTypes() {
        return personTypes;
    }

    public void setPersonTypes(List<PersonType> personTypes) {
        this.personTypes = personTypes;
    }

    public EmployeeData getEmployeeData() {
        return employeeData;
    }

    public void setEmployeeData(EmployeeData employeeData) {
        this.employeeData = employeeData;
    }
}
