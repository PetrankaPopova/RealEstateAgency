package com.example.realestateagency.controller;

import com.example.realestateagency.domain.entity.Buyer;
import com.example.realestateagency.domain.entity.Viewing;
import com.example.realestateagency.service.BuyerService;
import com.example.realestateagency.service.PurchaseRequestService;
import com.example.realestateagency.service.ViewingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private BuyerService buyerService;

    @Autowired
    private ViewingService viewingService;

    @Autowired
    private PurchaseRequestService purchaseRequestService;

    @GetMapping
    public String showPurchasePage(@RequestParam Long buyerId, Model model) {
        Buyer buyer = buyerService.findById(buyerId);
        List<Viewing> viewings = viewingService.findByBuyerId(buyerId);

        model.addAttribute("buyer", buyer);
        model.addAttribute("viewings", viewings);

        return "purchase"; // Връща името на Thymeleaf шаблона
    }

    @PostMapping("/create")
    public String createPurchaseRequest(@RequestParam Long buyerId, @RequestParam Long propertyId) {
        purchaseRequestService.createPurchaseRequest(buyerId, propertyId);
        return "redirect:/purchases"; // Redirect after processing

    }

    @GetMapping("/balance")
    public String getBalance(Model model) {
        BigDecimal totalBalance = purchaseRequestService.calculateTotalBalance();
        model.addAttribute("balance", totalBalance);
        return "balance";
    }
}
