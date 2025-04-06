package io.unodevs.SoBarba.model.dto;

import java.io.Serializable;

public class CreateCategoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Boolean active;
    private Long barberShop;

    public CreateCategoryDTO() {
    }

    public CreateCategoryDTO(Long id, String name, Boolean active, Long barberShop) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.barberShop = barberShop;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getBarberShop() {
        return barberShop;
    }

    public void setBarberShop(Long barberShop) {
        this.barberShop = barberShop;
    }
}
