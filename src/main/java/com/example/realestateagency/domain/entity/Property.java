package com.example.realestateagency.domain.entity;

import com.example.realestateagency.domain.enums.PropertyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "properties")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property extends BaseEntity {
    @Column(nullable = false)
    @NonNull
    private String description;
    @Column(nullable = false)
    @NonNull
    private String address;
    @Column(nullable = false)
    @NonNull
    private double price;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NonNull
    private PropertyType propertyType;
    @Column(nullable = false)
    @NonNull
    private double area;
    @ManyToOne
    @JoinColumn(name = "agent_id")
    @NonNull
    private Agent agent;
    @ManyToOne
    @JoinColumn(name = "agency_id")
    @NonNull
    private Agency agency;
}
