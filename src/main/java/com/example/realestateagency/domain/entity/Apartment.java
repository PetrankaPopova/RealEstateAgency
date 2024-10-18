package com.example.realestateagency.domain.entity;

import com.example.realestateagency.domain.enums.ApartmentType;
import com.example.realestateagency.domain.enums.ConstructionType;
import com.example.realestateagency.domain.enums.PropertyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
@Entity
@Table(name = "apartments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apartment extends Property{
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NonNull
    private ApartmentType apartmentType;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NonNull
    private ConstructionType constructionType;

    public Apartment(@NonNull String description, @NonNull String address, @NonNull double price, @NonNull double area, @NonNull Agent agent, @NonNull ApartmentType apartmentType, @NonNull ConstructionType constructionType) {
        super(description, address, price, PropertyType.APARTMENT, area, agent, agent.getAgency());
        this.apartmentType = apartmentType;
        this.constructionType = constructionType;
    }
}
