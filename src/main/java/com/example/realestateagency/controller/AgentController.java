package com.example.realestateagency.controller;


import com.example.realestateagency.domain.entity.Agent;
import com.example.realestateagency.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/agent")
public class AgentController {
    @Autowired
    private AgentService agentService;

    @GetMapping
    public String listAgents(Model model) {
        List<Agent> agents = agentService.getAllAgents();
        model.addAttribute("agents", agents);
        model.addAttribute("newAgent", new Agent());
        return "agents";
    }


    @PostMapping
    public String addAgent(@ModelAttribute Agent agent) {
        agentService.addAgent(agent);
        return "redirect:/agent";
    }

    @GetMapping("/edit/{id}")
    public String editAgentForm(@PathVariable Long id, Model model) {
        Optional<Agent> optionalAgent = agentService.getAllAgents().stream()
                .filter(agent -> agent.getId().equals(id))
                .findFirst();
        if (optionalAgent.isPresent()) {
            model.addAttribute("agent", optionalAgent.get());
            return "edit-agent";
        }
        return "redirect:/agent"; // или хвърлете изключение
    }


    @PostMapping("/edit/{id}")
    public String editAgent(@PathVariable Long id, @ModelAttribute Agent updatedAgent) {
        agentService.updateAgent(id, updatedAgent);
        return "redirect:/agent";
    }


    @PostMapping("/delete/{id}")
    public String deleteAgent(@PathVariable Long id) {
        agentService.deleteAgent(id);
        return "redirect:/agent";
    }
}
