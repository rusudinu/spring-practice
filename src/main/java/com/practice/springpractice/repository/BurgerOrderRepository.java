package com.practice.springpractice.repository;

import com.practice.springpractice.model.BurgerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BurgerOrderRepository extends JpaRepository<BurgerOrder, Long> {
}
