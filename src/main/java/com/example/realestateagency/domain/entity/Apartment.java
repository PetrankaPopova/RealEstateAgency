package com.example.realestateagency.domain.entity;

import com.example.realestateagency.domain.enums.ApartmentType;
import com.example.realestateagency.domain.enums.ConstructionType;
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
}
