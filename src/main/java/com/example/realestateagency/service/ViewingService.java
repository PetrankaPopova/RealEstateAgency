package com.example.realestateagency.service;

import com.example.realestateagency.domain.entity.Viewing;

import java.time.LocalDateTime;
import java.util.List;

public interface ViewingService {
    List<Viewing>findAll();
    void deleteViewing(Long id);
    public void createViewing(Long buyerId, Long propertyId, LocalDateTime date);
    List<Viewing> findByBuyerId(Long buyerId);
}
