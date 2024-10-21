package com.example.realestateagency.domain.entity;

import com.example.realestateagency.domain.enums.PropertyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "properties")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property extends BaseEntity {

    private String description;

    private String address;

    private double price;
    @Enumerated(EnumType.STRING)

    private PropertyType propertyType;

    private double area;
    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;
    @ManyToOne
    @JoinColumn(name = "agency_id")

    private Agency agency;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;
}
