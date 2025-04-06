package io.unodevs.SoBarba.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class BarberShopDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private String cnpj;
    private Boolean active;

    public BarberShopDTO() {
    }

    public BarberShopDTO(String name, String description, String cnpj, Boolean active) {
        this.name = name;
        this.description = description;
        this.cnpj = cnpj;
        this.active = active;
    }

    public BarberShopDTO(Long id, String name, String description, String cnpj, Boolean active) {
        this.id = id;
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
        BarberShopDTO that = (BarberShopDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(cnpj, that.cnpj) && Objects.equals(active, that.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, cnpj, active);
    }
}
