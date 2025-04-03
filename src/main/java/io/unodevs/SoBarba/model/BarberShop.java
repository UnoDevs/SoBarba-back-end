package io.unodevs.SoBarba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BarberShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String cnpj;

    private boolean isActive;

    public BarberShop() {
    }

    public BarberShop(Long id, String name, String description, String cnpj, boolean isActive) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cnpj = cnpj;
        this.isActive = isActive;
    }

    public BarberShop(String name, String description, String cnpj, boolean isActive) {
        this.name = name;
        this.description = description;
        this.cnpj = cnpj;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCnpj() {
        return cnpj;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
