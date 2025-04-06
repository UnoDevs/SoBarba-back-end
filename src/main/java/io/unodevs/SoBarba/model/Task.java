package io.unodevs.SoBarba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    private int timeConclusion;

    private String description;

    private boolean isActive;

    public  Task() {
    }

    public Task(Long id, String name, double price, int timeConclusion, String description, boolean isActive) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.timeConclusion = timeConclusion;
        this.description = description;
        this.isActive = isActive;
    }

    public Task(String name, double price, int timeConclusion, String description, boolean isActive) {
        this.name = name;
        this.price = price;
        this.timeConclusion = timeConclusion;
        this.description = description;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getTimeConclusion() {
        return timeConclusion;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTimeConclusion(int timeConclusion) {
        this.timeConclusion = timeConclusion;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
