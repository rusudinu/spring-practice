package com.practice.springpractice.controller;


import com.practice.springpractice.model.ShoeOrder;
import com.practice.springpractice.service.ShoeOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoe-order")
@RequiredArgsConstructor
public class ShoeOrderController {

    private final ShoeOrderService shoeOrderService;

    @GetMapping
    public List<ShoeOrder> getShoeOrders(){return shoeOrderService.getAllShoeOrders();}

    @PostMapping()
    public ShoeOrder createShoeOrder(@RequestParam Long id, @RequestParam Long quantity){
        return shoeOrderService.createOrder(id, quantity);
    }
}
