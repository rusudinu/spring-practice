package com.practice.springpractice.service;


import com.practice.springpractice.model.Burger;
import com.practice.springpractice.repository.BurgerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BurgerService {

    private final BurgerRepository burgerRepository;


    public Burger addBurger( Burger burger)
    {
        return burgerRepository.save(burger);
    }


    public Burger updateBurger(Burger burger) {
        return burgerRepository.save(burger);
    }

    public void deleteBurger(Long id) {
        burgerRepository.deleteById(id);
    }

    public Burger getBurger(Long id) {

        return burgerRepository.findById( id ).get();
    }

    public List<Burger> getAllBurgers() {
        return burgerRepository.findAll();
    }
}
