package com.practice.springpractice.repository;

import com.practice.springpractice.model.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ToyRepository extends JpaRepository<Toy, Long> {
    Toy findByName(String name);

    @Query("SELECT t FROM Toy t WHERE t.quantity < 10")
    List<Toy> lowStockToys();

    @Query(nativeQuery = true, value = "SELECT * FROM toy WHERE quantity < 10")
    List<Toy> lowStockToysNative();

    // List<Toy> findAll(Pageable pageable);

    @Modifying
    @Query("UPDATE Toy t SET t.quantity = t.quantity + 1 WHERE t.id = ?1")
    void incrementQuantity(Long id);

    @Modifying
    @Query("UPDATE Toy t SET t.quantity = t.quantity - 1 WHERE t.id = ?1")
    void decrementQuantity(Long id);
}
