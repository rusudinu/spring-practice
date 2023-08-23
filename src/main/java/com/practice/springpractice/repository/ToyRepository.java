package com.practice.springpractice.repository;

import com.practice.springpractice.model.Toy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToyRepository extends JpaRepository<Toy, Long> {
    Toy findByName(String name);
}
