package com.practice.springpractice.mapper;

import com.practice.springpractice.dto.ToyDTO;
import com.practice.springpractice.model.Toy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ToyMapper {
    Toy toToy(ToyDTO toyDTO);

    ToyDTO toToyDTO(Toy toy);
}
