package com.example.realestateagency.service.impl;

import com.example.realestateagency.domain.entity.Buyer;
import com.example.realestateagency.domain.entity.Property;
import com.example.realestateagency.domain.entity.PurchaseRequest;
import com.example.realestateagency.repository.BuyerRepository;
import com.example.realestateagency.repository.PropertyRepository;
import com.example.realestateagency.repository.PurchaseRequestRepository;
import com.example.realestateagency.service.PurchaseRequestService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PurchaseRequestServiceImpl implements PurchaseRequestService {
    @Autowired
    private PurchaseRequestRepository purchaseRequestRepository;
    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private PropertyRepository propertyRepository;
    @Override
    public void createPurchaseRequest(Long buyerId, Long propertyId) {
        Buyer buyer = buyerRepository.findById(buyerId)
                .orElseThrow(() -> new RuntimeException("Купувачът не беше намерен"));

        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Имотът не беше намерен"));

        PurchaseRequest request = new PurchaseRequest();
        request.setBuyer(buyer);
        request.setProperty(property);

        purchaseRequestRepository.save(request);

    }
    public BigDecimal calculateTotalBalance() {
        List<PurchaseRequest> purchases = purchaseRequestRepository.findAll();
        return purchases.stream()
                .map(PurchaseRequest::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
