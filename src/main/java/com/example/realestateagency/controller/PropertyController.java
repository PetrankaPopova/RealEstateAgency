package com.example.realestateagency.controller;

import com.example.realestateagency.domain.entity.Buyer;
import com.example.realestateagency.domain.entity.Property;
import com.example.realestateagency.service.BuyerService;
import com.example.realestateagency.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/property")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @Autowired
    private BuyerService buyerService;

    @GetMapping("/search")
    public String showSearchForm(Model model) {
        model.addAttribute("buyers", buyerService.findAll());
        return "property-search";
    }

    @PostMapping("/search")
    public String searchProperties(@RequestParam("buyerId") Long buyerId, Model model) {
        Buyer buyer = buyerService.findById(buyerId); // Fetch the buyer by ID
        List<Property> properties = propertyService.searchPropertiesByBuyer(buyer); // Search properties
        model.addAttribute("properties", properties);
        return "property-search";
    }
}


