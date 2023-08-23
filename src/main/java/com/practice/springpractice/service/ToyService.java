package com.practice.springpractice.service;

import com.practice.springpractice.model.Toy;
import com.practice.springpractice.repository.ToyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToyService {
    private final ToyRepository toyRepository;

    public List<Toy> getToys() {
        return toyRepository.findAll();
    }

    public Toy getToy(String name) {
        return toyRepository.findByName(name);
    }

    public Toy getToy(Long id) {
        return toyRepository.findById(id).orElse(null);
    }

    public Toy createToy(Toy toy) {
        return toyRepository.save(toy);
    }

    public Toy updateToy(Toy toy) {
        return toyRepository.save(toy);
    }

    public void deleteToy(Toy toy) {
        toyRepository.delete(toy);
    }

    public void deleteToy(Long id) {
        toyRepository.deleteById(id);
    }
}
