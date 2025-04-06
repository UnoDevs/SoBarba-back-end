package io.unodevs.SoBarba.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class TaskDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private Long id;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double price;
    private int timeConclusion;
    private String description;
    @JsonProperty(defaultValue = "true")
    private boolean isActive;
    public TaskDTO() {
    }

    public TaskDTO(String name, Double price, int timeConclusion, String description, boolean isActive) {
        this.name = name;
        this.price = price;
        this.timeConclusion = timeConclusion;
        this.description = description;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
