package com.practice.springpractice.controller;


import com.practice.springpractice.model.Burger;
import com.practice.springpractice.model.BurgerOrder;
import com.practice.springpractice.service.BurgerOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/burger-order")
public class BurgerOrderController {

    private final BurgerOrderService burgerOrderService;


    @GetMapping
    public ResponseEntity< List<BurgerOrder> > getAllOrders()
    {
        return  new ResponseEntity<>( burgerOrderService.getAllOrders() , HttpStatus.OK ) ;
    }

    @PostMapping
    public ResponseEntity<BurgerOrder> addBurgerOrder( @RequestParam Long id , @RequestParam Integer quantity ) {
        return new ResponseEntity<>(burgerOrderService.addBurgerOrder( id, quantity) , HttpStatus.OK);
    }

}
