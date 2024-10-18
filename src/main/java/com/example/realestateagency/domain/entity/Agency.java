package com.example.realestateagency.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "agency")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agency extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String contactPhone;
    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Agent> agents = new ArrayList<>();
    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Property> properties = new ArrayList<>();
    private double budget;

    public void addAgent(Agent agent) {
        agents.add(agent);
    }

    public void addProperty(Property property) {
        properties.add(property);
    }

    public void updateBudget(double amount) {
        this.budget += amount;
    }
}
