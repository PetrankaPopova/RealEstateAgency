package com.example.realestateagency.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "agents")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Agent extends BaseEntity {
    @Column(nullable = false)
    @NonNull
    private String name;
    @Column(nullable = false)
    @NonNull
    private String phone;
    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;
    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seller> sellers = new ArrayList<>();
    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Buyer> buyers = new ArrayList<>();
    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Viewing> viewings = new ArrayList<>();
    private double earnings;

    public void addSeller(Seller seller) {
        sellers.add(seller);
    }

    public void addBuyer(Buyer buyer) {
        buyers.add(buyer);
    }

    public void addViewing(Viewing viewing) {
        viewings.add(viewing);
    }

    public void addEarnings(double amount) {
        this.earnings += amount;
    }

}
