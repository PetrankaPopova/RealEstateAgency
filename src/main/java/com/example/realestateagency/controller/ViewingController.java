package com.example.realestateagency.controller;

import com.example.realestateagency.domain.entity.Buyer;
import com.example.realestateagency.service.BuyerService;
import com.example.realestateagency.service.ViewingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/viewings")
public class ViewingController {
    @Autowired
    BuyerService buyerService;
    @Autowired
    private ViewingService viewingService;

    @GetMapping
    public String showViewingsPage(Model model) {
        List<Buyer> buyers = buyerService.findAll();
        model.addAttribute("buyers", buyers);
        model.addAttribute("viewings", viewingService.findAll());
        model.addAttribute("selectedBuyer", buyers.isEmpty() ? null : buyers.get(0));

        return "viewing";
    }

    @PostMapping("/create")
    public String createViewing(@RequestParam Long buyerId, @RequestParam Long propertyId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        viewingService.createViewing(buyerId, propertyId, date);
        return "redirect:/viewings"; // Redirect to the viewings page after processing
    }


    @PostMapping("/delete/{id}")
    public String deleteViewing(@PathVariable Long id) {
        viewingService.deleteViewing(id);
        return "redirect:/viewings";
    }

}
