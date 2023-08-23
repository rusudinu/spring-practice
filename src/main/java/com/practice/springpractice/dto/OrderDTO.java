package com.practice.springpractice.dto;

import com.practice.springpractice.model.Toy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Integer total;
    private Integer quantityPurchased;
    private Toy toyPurchased;
}