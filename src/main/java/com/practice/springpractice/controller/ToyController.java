package com.practice.springpractice.controller;

import com.practice.springpractice.dto.ToyDTO;
import com.practice.springpractice.model.Toy;
import com.practice.springpractice.service.ToyService;
import com.practice.springpractice.service.ToyServiceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toys")
@RequiredArgsConstructor
public class ToyController {
    private final ToyService toyService;
    private final ToyServiceDTO toyServiceDTO;

    @GetMapping
    public List<Toy> getToys() {
        return toyService.getToys();
    }

    @GetMapping("/dto")
    public List<ToyDTO> getToysDTO() {
        return toyServiceDTO.getToys();
    }

    @GetMapping("/dto/{id}")
    public ToyDTO getToyDTO(@PathVariable Long id) {
        return toyServiceDTO.getToy(id);
    }

    @GetMapping("/dto/byName/{name}")
    public ToyDTO getToyDTO(@PathVariable String name) {
        return toyServiceDTO.getToy(name);
    }

    @GetMapping("/{id}")
    public Toy getToy(@PathVariable Long id) {
        return toyService.getToy(id);
    }

    @GetMapping("/byName/{name}")
    public Toy getToy(@PathVariable String name) {
        return toyService.getToy(name);
    }

    @PostMapping
    public Toy createToy(@RequestBody Toy toy) {
        return toyService.createToy(toy);
    }

    @PutMapping
    public Toy updateToy(@RequestBody Toy toy) {
        return toyService.updateToy(toy);
    }

    @DeleteMapping("/{id}")
    public void deleteToy(@PathVariable Long id) {
        toyService.deleteToy(id);
    }

    @DeleteMapping
    public void deleteToy(@RequestBody Toy toy) {
        toyService.deleteToy(toy);
    }
}
