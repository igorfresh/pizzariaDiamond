package br.com.fiap.pizzariadiamond.repository;

import br.com.fiap.pizzariadiamond.model.Pizza;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {

    Page<Pizza> findAll(Pageable pageable);
    Page<Pizza> findByNameContaining(String name, Pageable pageable);
}
