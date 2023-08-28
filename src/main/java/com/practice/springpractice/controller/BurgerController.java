package com.practice.springpractice.controller;


import com.practice.springpractice.model.Burger;
import com.practice.springpractice.service.BurgerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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

    public boolean isBurgerInValid(Burger burger) {
        return burger.getDescription() == null || burger.getPrice() == null;
    }

    @PostMapping
    public ResponseEntity<Burger> addBurger(@RequestBody Burger burger)
    {
        if(isBurgerInValid(burger)) {
            return new ResponseEntity<>( null , HttpStatus.BAD_REQUEST ) ;
        }

        return new ResponseEntity<>( burgerService.addBurger( burger ) , HttpStatus.CREATED ) ;
    }


    @PutMapping
    public ResponseEntity<Burger> updateBurger( @RequestBody Burger burger)
    {
        if(isBurgerInValid(burger)) {
            return new ResponseEntity<>( null , HttpStatus.BAD_REQUEST ) ;
        }

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
        Burger burgerFound = burgerService.getBurger( id );

        if(burgerFound == null) {
            return new ResponseEntity<>( null , HttpStatus.NOT_FOUND ) ;
        }

        return  new ResponseEntity<>( burgerFound , HttpStatus.OK) ;
    }

    @GetMapping
    public ResponseEntity < List<Burger> >  getAllBurgers()
    {
        List<Burger> allBurgers = burgerService.getAllBurgers();

        if(allBurgers.size() == 0) {
            return  new ResponseEntity<>( allBurgers, HttpStatus.NOT_FOUND) ;
        }

        return  new ResponseEntity<>( allBurgers, HttpStatus.OK) ;
    }

    @GetMapping("/paginated")
    public Page<Burger> getAllBurgersPaginated(@RequestParam(required = false, defaultValue = "0") Integer pageNo,
                                                @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return burgerService.getAllBurgersPaginated(pageNo, pageSize);
    }

    @GetMapping("/paginated/sorted")
    public Page<Burger> getAllBurgersPaginatedAndSorted(@RequestParam(required = false, defaultValue = "0") Integer pageNo,
                                                @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                                @RequestParam(required = false, defaultValue = "price") String criteria) {
        return burgerService.getAllBurgersPaginatedAndSorted(pageNo, pageSize, criteria);
    }


}
