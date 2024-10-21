package com.example.realestateagency.repository;

import com.example.realestateagency.domain.entity.PurchaseRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRequestRepository extends JpaRepository<PurchaseRequest , Long> {
    List<PurchaseRequest> findAllByOrderByPurchaseDateDesc();
}
