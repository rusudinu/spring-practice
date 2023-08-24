package com.practice.springpractice.controller;


import com.practice.springpractice.model.Burger;
import com.practice.springpractice.service.BurgerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/burger")
public class BurgerController {

    private final BurgerService burgerService;

    @PostMapping
    public Burger addBurger(@RequestBody Burger burger)
    {
        return burgerService.addBurger( burger );
    }


    @PutMapping
    public Burger updateBurger( @RequestBody Burger burger)
    {
        return burgerService.updateBurger( burger);
    }

    @DeleteMapping("/{id}")
    public void deleteBurger ( @PathVariable Long id )
    {
        burgerService.deleteBurger( id );
    }

    @GetMapping("{id}")
    public Burger getBurger ( @PathVariable Long id)
    {
        return burgerService.getBurger( id );

    }

    @GetMapping
    public List<Burger> getAllBurgers()
    {
        return burgerService.getAllBurgers();

    }



}
