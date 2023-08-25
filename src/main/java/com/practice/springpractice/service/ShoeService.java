package com.practice.springpractice.service;

import com.practice.springpractice.model.Shoe;
import com.practice.springpractice.repository.ShoeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShoeService {
    private final ShoeRepository shoeRepository;

    public List<Shoe> getShoes() {
        log.warn("Get all shoes!");
        return shoeRepository.findAll();
    }

    public Shoe getShoe(Long id) {
        return shoeRepository.findById(id).orElse(null);
    }

    public Shoe createShoe(Shoe shoe) {
        log.error("Shoe created!");
        return shoeRepository.save(shoe);
    }

    public void deleteShoe(Long id) {
        shoeRepository.deleteById(id);
    }

}
