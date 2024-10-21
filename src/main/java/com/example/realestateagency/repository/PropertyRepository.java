package com.example.realestateagency.repository;

import com.example.realestateagency.domain.entity.Buyer;
import com.example.realestateagency.domain.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findByBuyer(Buyer buyer);
}
