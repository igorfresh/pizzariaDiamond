package br.com.fiap.pizzariadiamond.controller;

import br.com.fiap.pizzariadiamond.model.Order;
import br.com.fiap.pizzariadiamond.model.Pizza;
import br.com.fiap.pizzariadiamond.repository.OrderRepository;
import br.com.fiap.pizzariadiamond.repository.PizzaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {


    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public Order create(@RequestBody @Valid Order order) {
        return orderRepository.save(order);
    }

    @GetMapping
    public Page<Order> getAllOrders(
            @PageableDefault Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @GetMapping("{id}")
    public Optional<Order> show(@PathVariable Long id) {
        return orderRepository.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderRepository.deleteById(id);
    }

}
