package com.example.realestateagency.service;

import com.example.realestateagency.domain.entity.Buyer;

import java.util.List;

public interface BuyerService {
    List<Buyer> findAll();
    void save(Buyer buyer);
    void deleteById(Long id);
    Buyer findById(Long id);
    Buyer updateBuyer(Long id, Buyer updatedBuyer);
    List<Buyer> getAllBuyers();
}
