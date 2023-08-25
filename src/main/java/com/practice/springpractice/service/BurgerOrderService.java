package com.practice.springpractice.service;

import com.practice.springpractice.model.Burger;
import com.practice.springpractice.model.BurgerOrder;
import com.practice.springpractice.repository.BurgerOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor

public class BurgerOrderService {

    private final BurgerOrderRepository burgerOrderRepository;
    private final BurgerService burgerService;


    public List<BurgerOrder> getAllOrders() {
        log.info("Get all orders.");
        return burgerOrderRepository.findAll();
    }

    public BurgerOrder addBurgerOrder(Long id, Integer quantity) {

        log.info("Creating order for burger with id " + id);
        Burger burger = burgerService.getBurger(id);

        return burgerOrderRepository.save(new BurgerOrder(null, quantity, id, (double) burger.getPrice() * quantity));
    }
}
