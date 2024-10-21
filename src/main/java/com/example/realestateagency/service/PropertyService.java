package com.example.realestateagency.service;

import com.example.realestateagency.domain.entity.Buyer;
import com.example.realestateagency.domain.entity.Property;

import java.util.List;

public interface PropertyService {
    List<Property> searchPropertiesByBuyer(Buyer buyer);
    List<Property>findAll();

}
