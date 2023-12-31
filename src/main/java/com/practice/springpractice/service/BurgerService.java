package com.practice.springpractice.service;


import com.practice.springpractice.model.Burger;
import com.practice.springpractice.repository.BurgerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BurgerService {

    private final BurgerRepository burgerRepository;


    public Burger addBurger( Burger burger)
    {
        log.info("Creating burger");
        return burgerRepository.save(burger);
    }


    public Burger updateBurger(Burger burger) {
        log.info("Updating burger");
        return burgerRepository.save(burger);
    }

    public void deleteBurger(Long id) {
        log.info("Deleting burger");
        burgerRepository.deleteById(id);
    }

    public Burger getBurger(Long id) {
        log.info("Getting burger with id " + id);

        return burgerRepository.findById( id ).orElse(null);
    }

    public List<Burger> getAllBurgers() {
        log.info("Listing all burgers");
        return burgerRepository.findAll();
    }

    public Page<Burger> getAllBurgersPaginated(Integer pageNo, Integer pageSize) {
        return burgerRepository.findAll(PageRequest.of(pageNo, pageSize));
    }

    public Page<Burger> getAllBurgersPaginatedAndSorted(Integer pageNo, Integer pageSize, String criteria) {
        return burgerRepository.findAll(PageRequest.of(pageNo, pageSize, Sort.by(criteria)));
    }
}
