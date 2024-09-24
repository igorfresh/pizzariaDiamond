package br.com.fiap.pizzariadiamond.controller;

import br.com.fiap.pizzariadiamond.model.Pizza;
import br.com.fiap.pizzariadiamond.repository.PizzaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @PostMapping
    public Pizza create(@RequestBody @Valid Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    @GetMapping
    public Page<Pizza> getAllPizzas(
            @PageableDefault Pageable pageable) {
        return pizzaRepository.findAll(pageable);
    }

    @GetMapping("{id}")
    public Optional<Pizza> show(@PathVariable Long id) {
        return pizzaRepository.findById(id);
    }

//    @GetMapping("/search")
//    public Page<Pizza> searchPizzas(@RequestParam String name, @RequestParam int page, @RequestParam int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        return pizzaRepository.findByNameContaining(name, pageable);
//    }

    @DeleteMapping("{id}")
    public void deletePizza(@PathVariable Long id) {
        pizzaRepository.deleteById(id);
    }
}
