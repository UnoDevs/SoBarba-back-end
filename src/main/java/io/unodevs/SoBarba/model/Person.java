package io.unodevs.SoBarba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDate birthDate;
    private String email;
    private String phone;
    private Boolean active;

    public Person() {
    }

    public Person(String name, String description, LocalDate birthDate, String email, String phone, Boolean active) {
        this.name = name;
        this.description = description;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.active = active;
    }

    public Person(Long id, String name, String description, LocalDate birthDate, String email, String phone, Boolean active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.active = active;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(description, person.description) && Objects.equals(birthDate, person.birthDate) && Objects.equals(email, person.email) && Objects.equals(phone, person.phone) && Objects.equals(active, person.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, birthDate, email, phone, active);
    }
}
