package com.example.realestateagency.service.impl;


import com.example.realestateagency.domain.entity.Agent;
import com.example.realestateagency.domain.entity.Buyer;
import com.example.realestateagency.repository.BuyerRepository;
import com.example.realestateagency.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private BuyerRepository buyerRepository;

    @Override
    public List<Buyer> findAll() {
        return buyerRepository.findAll();
    }

    @Override
    public void save(Buyer buyer) {
        buyerRepository.save(buyer);
    }

    @Override
    public void deleteById(Long id) {
        buyerRepository.deleteById(id);
    }

    @Override
    public Buyer findById(Long id) {
        return buyerRepository.findById(id).orElse(null);
    }

    @Override
    public Buyer updateBuyer(Long id, Buyer updatedBuyer) {
        Optional<Buyer> optionalAgent = buyerRepository.findById(id);
        if (optionalAgent.isPresent()) {
            Buyer buyer = optionalAgent.get();
            buyer.setName(updatedBuyer.getName());

            buyerRepository.save(buyer);
            return buyer;
        }
        return null;
    }

    @Override
    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

}


