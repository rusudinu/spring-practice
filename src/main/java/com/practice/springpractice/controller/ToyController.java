package com.practice.springpractice.controller;

import com.practice.springpractice.dto.ToyDTO;
import com.practice.springpractice.model.Toy;
import com.practice.springpractice.service.ToyService;
import com.practice.springpractice.service.ToyServiceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toys")
@RequiredArgsConstructor
public class ToyController {
    private final ToyService toyService;
    private final ToyServiceDTO toyServiceDTO;

    @GetMapping("/toys")
    public Page<Toy> getToysPaginated(@RequestParam(required = false, defaultValue = "0") Integer pageNo,
                                      @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return toyService.getToysPaginated(pageNo, pageSize);
    }

    @GetMapping("/sorted-toys")
    public Page<Toy> getToysPaginatedAndSorted(@RequestParam(required = false, defaultValue = "0") Integer pageNo,
                                               @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return toyService.getToysPaginatedAndSorted(pageNo, pageSize);
    }

    @GetMapping("/low-stock-toys")
    public List<Toy> getLowStockToys() {
        return toyService.getLowStockToys();
    }

    @GetMapping("/low-stock-toys-native")
    public List<Toy> getLowStockToysNative() {
        return toyService.getLowStockToysNative();
    }

    @PutMapping("/increment/{id}")
    public void incrementQuantity(@PathVariable Long id) {
        toyService.incrementQuantity(id);
    }

    @PutMapping("/decrement/{id}")
    public void decrementQuantity(@PathVariable Long id) {
        toyService.decrementQuantity(id);
    }

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
