package com.practice.springpractice.controller;


import com.practice.springpractice.model.Burger;
import com.practice.springpractice.model.BurgerOrder;
import com.practice.springpractice.service.BurgerOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/burger-order")
public class BurgerOrderController {

    private final BurgerOrderService burgerOrderService;


    @GetMapping
    public List<BurgerOrder> getAllOrders()
    {
        return burgerOrderService.getAllOrders();
    }

    @PostMapping
    public BurgerOrder addBurgerOrder( @RequestParam Long id , @RequestParam Integer quantity ) {
        return burgerOrderService.addBurgerOrder( id, quantity);
    }

}
