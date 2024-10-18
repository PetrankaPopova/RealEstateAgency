package com.example.realestateagency.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


import java.util.Date;
@Entity
@Table(name = "viewings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Viewing extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "property_id")
    @NonNull
    private Property property;
    @ManyToOne
    @JoinColumn(name = "agent_id")
    @NonNull
    private Agent agent;
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    @NonNull
    private Buyer buyer;
    @NonNull
    private Date date;
}
