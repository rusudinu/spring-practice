package com.practice.springpractice.repository;

import com.practice.springpractice.model.ShoeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoeOrderRepository extends JpaRepository<ShoeOrder, Long> {

}
