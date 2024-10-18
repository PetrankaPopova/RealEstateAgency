package com.example.realestateagency.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "buyers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Buyer extends Client{
    @Column(nullable = false)
    @NonNull
    private double budget;
    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Viewing> viewings = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    public Buyer(@NonNull String name, @NonNull String phone, @NonNull double budget) {
        super(name, phone);
        this.budget = budget;
    }

    public void addViewing(Viewing viewing) {
        viewings.add(viewing);
    }
}
