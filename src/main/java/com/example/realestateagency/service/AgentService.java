package com.example.realestateagency.service;

import com.example.realestateagency.domain.entity.Agent;

import java.util.List;

public interface AgentService {
    Agent addAgent(Agent agent);

    Agent updateAgent(Long id, Agent agent);

    void deleteAgent(Long id);

    List<Agent> getAllAgents();

}
