package com.example.realestateagency.domain.entity;

import com.example.realestateagency.domain.enums.ConstructionType;
import com.example.realestateagency.domain.enums.HouseType;
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

}
