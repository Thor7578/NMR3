package com.example.demo.controllers;

import com.example.demo.repositories.IOrderRepo;
import com.example.demo.repositories.ISeasonsRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
    private IOrderRepo orderRepository;
    private ISeasonsRepo seasonRepository;


    @GetMapping("/sales")                           // Access to sales subsection
    public String sales (Model model){
        indexRead(model);
        return "sales";
    }

    public void indexRead(Model model) {
        model.addAttribute("seasons", seasonRepository.readAll());
        model.addAttribute("orders", orderRepository.readAll());
    }
}
