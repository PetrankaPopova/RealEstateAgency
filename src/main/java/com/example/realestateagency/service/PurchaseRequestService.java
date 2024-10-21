package com.example.realestateagency.service;

import java.math.BigDecimal;

public interface PurchaseRequestService {
    void createPurchaseRequest(Long buyerId, Long propertyId);

    BigDecimal calculateTotalBalance();
}
