package com.example.realestateagency.service.impl;


import com.example.realestateagency.domain.entity.Seller;
import com.example.realestateagency.repository.SellerRepository;
import com.example.realestateagency.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    @Override
    public void addSeller(Seller seller) {
        sellerRepository.save(seller);
    }

    @Override
    public Seller updateSeller(Long id, Seller updatedSeller) {
        Optional<Seller> optionalAgent = sellerRepository.findById(id);
        if (optionalAgent.isPresent()) {
            Seller seller = optionalAgent.get();
            seller.setName(updatedSeller.getName());
            seller.setPhone(updatedSeller.getPhone());
            sellerRepository.save(seller);
            return seller;
        }
        return null;//trow ex

    }

    @Override
    public void deleteSeller(Long id) {
        this.sellerRepository.deleteById(id);

    }

}