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
    private Long categoryId;

    public TaskDTO() {
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
