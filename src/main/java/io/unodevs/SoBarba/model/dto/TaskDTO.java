package io.unodevs.SoBarba.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Objects;


public class TaskDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private double price;
    private int timeConclusion;
    private String description;
    private Boolean active = true;
    public TaskDTO() {
    }

    public TaskDTO(String name, Double price, int timeConclusion, String description, boolean active) {
        this.name = name;
        this.price = price;
        this.timeConclusion = timeConclusion;
        this.description = description;
        this.active = active;
    }

    public TaskDTO(Long id, String name, double price, int timeConclusion, String description, boolean active) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.timeConclusion = timeConclusion;
        this.description = description;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeConclusion() {
        return timeConclusion;
    }

    public void setTimeConclusion(int timeConclusion) {
        this.timeConclusion = timeConclusion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        TaskDTO taskDTO = (TaskDTO) o;
        return Double.compare(price, taskDTO.price) == 0 && timeConclusion == taskDTO.timeConclusion && active == taskDTO.active && Objects.equals(id, taskDTO.id) && Objects.equals(name, taskDTO.name) && Objects.equals(description, taskDTO.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, timeConclusion, description, active);
    }
}
