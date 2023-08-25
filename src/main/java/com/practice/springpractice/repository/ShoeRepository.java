package com.practice.springpractice.repository;

import com.practice.springpractice.model.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoeRepository extends JpaRepository<Shoe, Long> {

}
