package com.example.demo.controllers;

import com.example.demo.repositories.IOrderRepo;
import com.example.demo.repositories.ISeasonsRepo;
import com.example.demo.repositories.OrderRepoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
    private IOrderRepo orderRepository;

    public OrderController(){
        orderRepository = new OrderRepoImpl();
    }


    @GetMapping("/sales")                           // Access to sales subsection
    public String sales (Model model){
        indexRead(model);
        model.addAttribute("activeOrders", orderRepository.readActive());
        model.addAttribute("endedOrders", orderRepository.readEnded());
        return "sales";
    }

    @GetMapping("/addSale")
    public String addSale(Model model){
        return "addSale";
    }

    public void indexRead(Model model) {
        model.addAttribute("orders", orderRepository.readAll());
    }
}
