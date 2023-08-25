package com.practice.springpractice.mapper;


import com.practice.springpractice.dto.ShoeDTO;
import com.practice.springpractice.model.Shoe;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShoeMapper {
    ShoeDTO toShoeDTO(Shoe shoe);
}
