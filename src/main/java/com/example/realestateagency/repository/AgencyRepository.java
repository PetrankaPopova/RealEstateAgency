package com.example.realestateagency.repository;

import com.example.realestateagency.domain.entity.Agency;
import com.example.realestateagency.domain.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {
    Agent findByName(String name);
}
