package com.practice.springpractice.service;


import com.practice.springpractice.model.Shoe;
import com.practice.springpractice.model.ShoeOrder;
import com.practice.springpractice.repository.ShoeOrderRepository;
import com.practice.springpractice.repository.ShoeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShoeOrderService {
    private final ShoeOrderRepository shoeOrderRepository;
    private final ShoeRepository shoeRepository;

    public List<ShoeOrder> getAllShoeOrders(){
        log.info("Get all shoe orders!");
        return shoeOrderRepository.findAll();
    }

    public ShoeOrder createOrder(Long shoeId, Long quantity){
        log.info("Get all shoe orders!");
        Shoe shoe = shoeRepository.findById(shoeId).get();
        log.warn("Found shoe with id " + shoe.getId());
        return shoeOrderRepository.save(new ShoeOrder(null, shoe.getPrice()*quantity, shoeId));
    }


}
