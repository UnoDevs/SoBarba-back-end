package io.unodevs.SoBarba.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "barbershop")
public class BarberShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "active")
    private Boolean active;

    public BarberShop() {
    }

    public BarberShop(Long id, String name, String description, String cnpj, boolean active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cnpj = cnpj;
        this.active = active;
    }

    public BarberShop(String name, String description, String cnpj, boolean active) {
        this.name = name;
        this.description = description;
        this.cnpj = cnpj;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
        BarberShop that = (BarberShop) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(cnpj, that.cnpj) && Objects.equals(active, that.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, cnpj, active);
    }
}
