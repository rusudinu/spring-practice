package com.practice.springpractice.controller;

import com.practice.springpractice.dto.OrderDTO;
import com.practice.springpractice.model.Order;
import com.practice.springpractice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
//    private final OrderService orderService;
//
//    @GetMapping
//    public List<OrderDTO> getAllOrders() {
//        return orderService.getAllOrders();
//    }
//
//    @GetMapping("{orderId}")
//    public OrderDTO getOrderById(@PathVariable Long orderId) {
//        return orderService.getOrderById(orderId);
//    }
//
//    @PostMapping(value = "{toyId}", consumes = {"application/json"})
//    public Order addOrder(@RequestBody Order order, @PathVariable Long toyId) {
//        return orderService.addOrder(order, toyId);
//    }
}
