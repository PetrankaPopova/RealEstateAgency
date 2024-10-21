package com.example.realestateagency.service.impl;

import com.example.realestateagency.domain.entity.Agent;
import com.example.realestateagency.repository.AgentRepository;
import com.example.realestateagency.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;



@Service
public class AgentServiceImpl implements AgentService {
    @Autowired
    private AgentRepository agentRepository;

    @Override
    public Agent addAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    @Override
    public Agent updateAgent(Long id, Agent updatedAgent) {
        Optional<Agent> optionalAgent = agentRepository.findById(id);
        if (optionalAgent.isPresent()) {
            Agent agent = optionalAgent.get();
            agent.setName(updatedAgent.getName());
            agent.setPhone(updatedAgent.getPhone());
            agentRepository.save(agent);
            return agent;
        }
        return null; // to throw exception instead null
    }

    @Override
    public void deleteAgent(Long id) {
        agentRepository.deleteById(id);

    }

    @Override
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

}
