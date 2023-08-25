package com.practice.springpractice.controller;


import com.practice.springpractice.dto.ShoeDTO;
import com.practice.springpractice.mapper.ShoeMapper;
import com.practice.springpractice.model.Shoe;
import com.practice.springpractice.service.ShoeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoes")
@RequiredArgsConstructor
public class ShoeController {
    private final ShoeService shoeService;
    private final ShoeMapper shoeMapper;

    @GetMapping
    public List<Shoe> getShoes(){return shoeService.getShoes();}

    @GetMapping("/dto/{id}")
    public ShoeDTO getShoeById(@PathVariable Long id){
        return shoeMapper.toShoeDTO(shoeService.getShoe(id));
    }

    @DeleteMapping("/{id}")
    public void deleteShoes(@PathVariable Long id){shoeService.deleteShoe(id);}

    @PostMapping()
    public Shoe createShoe(@RequestBody Shoe shoe){return shoeService.createShoe(shoe);}
}
















