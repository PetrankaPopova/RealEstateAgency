package com.example.realestateagency.controller;

import com.example.realestateagency.domain.entity.Seller;
import com.example.realestateagency.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @GetMapping
    public String listSellers(Model model) {
        List<Seller> sellers = sellerService.getAllSellers();
        model.addAttribute("sellers", sellers);
        model.addAttribute("newSeller", new Seller());
        return "sellers"; // Връща името на Thymeleaf шаблона
    }

    @PostMapping
    public String addSeller(@ModelAttribute Seller seller) {
        sellerService.addSeller(seller);
        return "redirect:/seller";
    }


    @GetMapping("/edit/{id}")
    public String editSellerForm(@PathVariable Long id, Model model) {
        Optional<Seller> optionalSeller = sellerService.getAllSellers().stream()
                .filter(seller -> seller.getId().equals(id))
                .findFirst();
        if (optionalSeller.isPresent()) {
            model.addAttribute("seller", optionalSeller.get());
            return "edit-seller";
        }
        return "redirect:/seller";
    }

    @PostMapping("/edit/{id}")
    public String editSeller(@PathVariable Long id, @ModelAttribute Seller updatedSeller) {
        sellerService.updateSeller(id, updatedSeller);
        return "redirect:/seller";
    }

    @PostMapping("/delete/{id}")
    public String deleteSeller(@PathVariable Long id) {
        sellerService.deleteSeller(id);
        return "redirect:/seller";
    }
}
