package io.unodevs.SoBarba.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class PersonDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private LocalDate birthDate;
    private String email;
    private String phone;
    private Boolean active = true;

    public PersonDTO() {
    }

    public PersonDTO(String name, String description, LocalDate birthDate, String email, String phone, Boolean active) {
        this.name = name;
        this.description = description;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.active = active;
    }

    public PersonDTO(Long id, String name, String description, LocalDate birthDate, String email, String phone, Boolean active) {
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
        PersonDTO personDTO = (PersonDTO) o;
        return Objects.equals(id, personDTO.id) && Objects.equals(name, personDTO.name) && Objects.equals(description, personDTO.description) && Objects.equals(birthDate, personDTO.birthDate) && Objects.equals(email, personDTO.email) && Objects.equals(phone, personDTO.phone) && Objects.equals(active, personDTO.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, birthDate, email, phone, active);
    }
}
