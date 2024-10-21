package com.example.realestateagency.domain.entity;

import com.example.realestateagency.domain.enums.PlotType;
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
}