package com.practice.springpractice.service;

import com.practice.springpractice.dto.OrderDTO;
import com.practice.springpractice.mapper.OrderMapper;
import com.practice.springpractice.model.Order;
import com.practice.springpractice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();

        return orders.stream().map(orderMapper::toOrderDTO).collect(Collectors.toList());
    }

    public OrderDTO getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);

        return orderMapper.toOrderDTO(order);
    }

    public Order addOrder(OrderDTO orderToAdd) {
        return orderRepository.save(orderMapper.toOrder(orderToAdd));
    }
}
