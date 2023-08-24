package com.practice.springpractice.service;

import com.practice.springpractice.model.Toy;
import com.practice.springpractice.repository.ToyRepository;
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
public class ToyService {
    private final ToyRepository toyRepository;

    public List<Toy> getToys() {
        log.info("getToys() called");
        log.warn("getToys() called as a warning");
        log.error("getToys() called as am error");
        return toyRepository.findAll();
    }

    public Page<Toy> getToysPaginated(Integer pageNo, Integer pageSize) {
        return toyRepository.findAll(PageRequest.of(pageNo, pageSize));
    }

    public Page<Toy> getToysPaginatedAndSorted(Integer pageNo, Integer pageSize) {
        return toyRepository.findAll(PageRequest.of(pageNo, pageSize, Sort.by("quantity").descending()));
    }

    public List<Toy> getLowStockToys() {
        return toyRepository.lowStockToys();
    }

    public List<Toy> getLowStockToysNative() {
        return toyRepository.lowStockToysNative();
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
