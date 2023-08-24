package com.practice.springpractice.repository;

import com.practice.springpractice.model.Burger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BurgerRepository extends JpaRepository<Burger, Long> {
}
