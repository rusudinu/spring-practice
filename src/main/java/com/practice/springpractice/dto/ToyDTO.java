package com.practice.springpractice.dto;

import com.practice.springpractice.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToyDTO {
    private String name;
    private String color;

    private List<Order> orders;
}
