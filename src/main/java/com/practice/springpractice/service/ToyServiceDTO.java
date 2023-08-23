package com.practice.springpractice.service;

import com.practice.springpractice.dto.ToyDTO;
import com.practice.springpractice.mapper.ToyMapper;
import com.practice.springpractice.repository.ToyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToyServiceDTO {
    private final ToyRepository toyRepository;
    private final ToyMapper toyMapper;

    public List<ToyDTO> getToys() {
        return toyRepository.findAll().stream().map(toyMapper::toToyDTO).toList();
    }

    public ToyDTO getToy(String name) {
        return toyMapper.toToyDTO(toyRepository.findByName(name));
    }

    public ToyDTO getToy(Long id) {
        return toyMapper.toToyDTO(toyRepository.findById(id).orElse(null));
    }
}
