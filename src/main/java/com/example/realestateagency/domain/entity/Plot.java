package com.example.realestateagency.domain.entity;

import com.example.realestateagency.domain.enums.PlotType;
import com.example.realestateagency.domain.enums.PropertyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "plots")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plot extends Property {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NonNull
    private PlotType plotType;
    private boolean regulated;

    public Plot(@NonNull String description, @NonNull String address, @NonNull double price, @NonNull double area, @NonNull Agent agent, @NonNull PlotType plotType, boolean regulated) {
        super(description, address, price, PropertyType.PLOT, area, agent, agent.getAgency());
        this.plotType = plotType;
        this.regulated = regulated;
    }
}