package com.example.realestateagency.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "clients")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Client extends BaseEntity {
    @Column(nullable = false)
    @NonNull
    protected String name;
    @Column(nullable = false)
    @NonNull
    protected String phone;
}


