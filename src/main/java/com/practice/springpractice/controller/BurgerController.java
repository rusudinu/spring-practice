package com.practice.springpractice.controller;


import com.practice.springpractice.model.Burger;
import com.practice.springpractice.service.BurgerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/burger")
public class BurgerController {

    private final BurgerService burgerService;

    @PostMapping
    public ResponseEntity<Burger> addBurger(@RequestBody Burger burger)
    {
        return new ResponseEntity<>( burgerService.addBurger( burger ) , HttpStatus.CREATED ) ;
    }


    @PutMapping
    public ResponseEntity<Burger> updateBurger( @RequestBody Burger burger)
    {
        return  new ResponseEntity<>( burgerService.updateBurger( burger) , HttpStatus.CREATED) ;
    }

    @DeleteMapping("/{id}")
    public void deleteBurger ( @PathVariable Long id )
    {
        burgerService.deleteBurger( id );
    }

    @GetMapping("{id}")
    public ResponseEntity<Burger> getBurger ( @PathVariable Long id)
    {
        return  new ResponseEntity<>( burgerService.getBurger( id ) , HttpStatus.OK) ;
    }

    @GetMapping
    public ResponseEntity < List<Burger> >  getAllBurgers()
    {
        return  new ResponseEntity<>( burgerService.getAllBurgers(), HttpStatus.OK) ;
    }



}
