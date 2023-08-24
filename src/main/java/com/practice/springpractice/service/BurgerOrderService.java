package com.practice.springpractice.service;

import com.practice.springpractice.model.Burger;
import com.practice.springpractice.model.BurgerOrder;
import com.practice.springpractice.repository.BurgerOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor

public class BurgerOrderService {

    private final BurgerOrderRepository burgerOrderRepository;
    private final BurgerService burgerService;





    public List<BurgerOrder> getAllOrders() {
        return burgerOrderRepository.findAll();
    }

    public BurgerOrder addBurgerOrder(Long id, Integer quantity) {

        Burger burger = burgerService.getBurger(id);

        return burgerOrderRepository.save(  new BurgerOrder( null , quantity, id , (double) burger.getPrice() * quantity ));
    }
}
