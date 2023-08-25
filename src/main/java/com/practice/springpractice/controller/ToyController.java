package com.practice.springpractice.controller;

import com.practice.springpractice.dto.ToyDTO;
import com.practice.springpractice.model.Toy;
import com.practice.springpractice.service.ToyService;
import com.practice.springpractice.service.ToyServiceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Toy> getToy(@PathVariable Long id) {
        return new ResponseEntity<>(toyService.getToy(id), HttpStatus.OK);
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<Toy> getToy(@PathVariable String name) {

        return new ResponseEntity<>(toyService.getToy(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Toy> createToy(@RequestBody Toy toy) {
        return new ResponseEntity<>(toyService.createToy(toy), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Toy> updateToy(@RequestBody Toy toy) {
        return new ResponseEntity<>(toyService.updateToy(toy), HttpStatus.CREATED);
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
