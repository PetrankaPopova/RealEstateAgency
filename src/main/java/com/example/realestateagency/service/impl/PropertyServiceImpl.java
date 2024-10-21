package com.example.realestateagency.service.impl;

import com.example.realestateagency.domain.entity.Buyer;
import com.example.realestateagency.domain.entity.Property;
import com.example.realestateagency.repository.PropertyRepository;
import com.example.realestateagency.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public List<Property> searchPropertiesByBuyer(Buyer buyer) {
        return propertyRepository.findByBuyer(buyer);
    }

    @Override
    public List<Property> findAll() {
        return propertyRepository.findAll();
    }
}
