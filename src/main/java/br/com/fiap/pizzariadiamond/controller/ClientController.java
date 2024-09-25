package br.com.fiap.pizzariadiamond.controller;

import br.com.fiap.pizzariadiamond.model.Client;
import br.com.fiap.pizzariadiamond.model.Pizza;
import br.com.fiap.pizzariadiamond.repository.ClientRepository;
import br.com.fiap.pizzariadiamond.repository.PizzaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {


    @Autowired
    private ClientRepository clientRepository;

    @PostMapping
    public Client create(@RequestBody @Valid Client client) {
        return clientRepository.save(client);
    }

    @GetMapping
    public Page<Client> getAllClients(
            @PageableDefault Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @GetMapping("{id}")
    public Optional<Client> show(@PathVariable Long id) {
        return clientRepository.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteClient(@PathVariable Long id) {
        clientRepository.deleteById(id);
    }

}
