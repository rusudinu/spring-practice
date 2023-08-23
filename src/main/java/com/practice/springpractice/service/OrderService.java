package com.practice.springpractice.service;

import com.practice.springpractice.dto.OrderDTO;
import com.practice.springpractice.mapper.OrderMapper;
import com.practice.springpractice.model.Order;
import com.practice.springpractice.model.Toy;
import com.practice.springpractice.repository.OrderRepository;
import com.practice.springpractice.repository.ToyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ToyRepository toyRepository;
    private final OrderMapper orderMapper;

    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();

        return orders.stream().map(orderMapper::toOrderDTO).collect(Collectors.toList());
    }

    public OrderDTO getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);

        return orderMapper.toOrderDTO(order);
    }

    @Transactional
    public Order addOrder(Order order, Long toyId) {
        Toy toy = toyRepository.findById(toyId).orElse(null);

        System.out.println(toy.getName());

        order.setPurchasedToy(toy);

        Order orderToReturn =  orderRepository.save(order);
        List<Order> ordersSoFar = toy.getOrders();
        ordersSoFar.add(orderToReturn);
        toy.setOrders(ordersSoFar);

        toyRepository.save(toy);

        return orderToReturn;
    }
}
