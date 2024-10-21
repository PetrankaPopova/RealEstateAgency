package com.example.realestateagency.controller;


import com.example.realestateagency.domain.entity.Buyer;
import com.example.realestateagency.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/buyers")
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    @GetMapping
    public String listBuyers(Model model) {
        model.addAttribute("buyers", buyerService.findAll());
        return "buyers";
    }

    @GetMapping("/new")
    public String showAddBuyerForm(Model model) {
        model.addAttribute("buyer", new Buyer());
        return "add-buyer";
    }

    @PostMapping
    public String addBuyer(@ModelAttribute Buyer buyer) {
        buyerService.save(buyer);
        return "redirect:/buyers";
    }

    @PostMapping("/delete/{id}")
    public String deleteBuyer(@PathVariable Long id) {
        buyerService.deleteById(id);
        return "redirect:/buyers";
    }


    @GetMapping("/edit/{id}")
    public String editBuyerForm(@PathVariable Long id, Model model) {


        Optional<Buyer> optionalBuyer = buyerService.getAllBuyers().stream()
                .filter(buyer -> buyer.getId().equals(id))
                .findFirst();

        if (optionalBuyer.isPresent()) {
            model.addAttribute("buyer", optionalBuyer.get());
            return "edit-buyer";
        }
        return "redirect:/buyers";
    }

    @PostMapping("/edit/{id}")
    public String editBuyer(@PathVariable Long id, @ModelAttribute Buyer updatedBuyer) {
        buyerService.updateBuyer(id, updatedBuyer);
        return "redirect:/buyers";


    }
}
