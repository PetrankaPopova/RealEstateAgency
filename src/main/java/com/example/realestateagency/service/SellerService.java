package com.example.realestateagency.service;

import com.example.realestateagency.domain.entity.Seller;

import java.util.List;

public interface SellerService {
    List<Seller> getAllSellers();
    void addSeller(Seller seller);
    Seller updateSeller(Long id, Seller updatedSeller);
    void deleteSeller(Long id);

}
