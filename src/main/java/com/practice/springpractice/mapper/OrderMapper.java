package com.practice.springpractice.mapper;

import com.practice.springpractice.dto.OrderDTO;
import com.practice.springpractice.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface OrderMapper {
    Order toOrder(OrderDTO orderDTO);

    OrderDTO toOrderDTO(Order order);
}