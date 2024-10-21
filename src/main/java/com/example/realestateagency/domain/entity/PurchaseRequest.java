package com.example.realestateagency.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Data
public class PurchaseRequest extends BaseEntity {
    @ManyToOne
    private Buyer buyer;

    @ManyToOne
    private Property property;

    private LocalDateTime purchaseDate;
    private BigDecimal price;

}
