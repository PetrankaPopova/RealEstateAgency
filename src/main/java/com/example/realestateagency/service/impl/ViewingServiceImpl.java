package com.example.realestateagency.service.impl;

import com.example.realestateagency.domain.entity.Buyer;
import com.example.realestateagency.domain.entity.Property;
import com.example.realestateagency.domain.entity.Viewing;
import com.example.realestateagency.repository.BuyerRepository;
import com.example.realestateagency.repository.PropertyRepository;
import com.example.realestateagency.repository.ViewingRepository;
import com.example.realestateagency.service.ViewingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class ViewingServiceImpl implements ViewingService {
    @Autowired
    private ViewingRepository viewingRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private BuyerRepository buyerRepository;

    @Override
    public List<Viewing> findAll() {
        return viewingRepository.findAll();
    }

    @Override
    public void deleteViewing(Long id) {
        viewingRepository.deleteById(id);
    }
    public void createViewing(Long buyerId, Long propertyId, LocalDateTime date) {
        Buyer buyer = buyerRepository.findById(buyerId).orElseThrow(() -> new IllegalArgumentException("Invalid buyer ID"));
        Property property = propertyRepository.findById(propertyId).orElseThrow(() -> new IllegalArgumentException("Invalid property ID"));

        Viewing viewing = new Viewing();
        viewing.setBuyer(buyer);
        viewing.setProperty(property);
        viewing.setDate(date);

        viewingRepository.save(viewing);
    }

    @Override
    public List<Viewing> findByBuyerId(Long buyerId) {
        return viewingRepository.findByBuyerId(buyerId);
    }


}
