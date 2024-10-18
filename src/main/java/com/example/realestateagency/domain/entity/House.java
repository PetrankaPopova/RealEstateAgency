package com.example.realestateagency.domain.entity;

import com.example.realestateagency.domain.enums.ConstructionType;
import com.example.realestateagency.domain.enums.HouseType;
import com.example.realestateagency.domain.enums.PropertyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
@Entity
@Table(name = "houses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class House extends Property{
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NonNull
    private HouseType houseType;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NonNull
    private ConstructionType constructionType;
    private int parkingSpaces;
    private double yardArea;

    public House(@NonNull String description, @NonNull String address, @NonNull double price, @NonNull double area, @NonNull Agent agent, @NonNull HouseType houseType, @NonNull ConstructionType constructionType, int parkingSpaces, double yardArea) {
        super(description, address, price, PropertyType.HOUSE, area, agent, agent.getAgency());
        this.houseType = houseType;
        this.constructionType = constructionType;
        this.parkingSpaces = parkingSpaces;
        this.yardArea = yardArea;
    }
}
