package com.example.realestateagency.repository;

import com.example.realestateagency.domain.entity.Viewing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewingRepository extends JpaRepository<Viewing, Long> {
    List<Viewing> findByBuyerId(Long buyerId);
}
