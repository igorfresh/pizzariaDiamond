package br.com.fiap.pizzariadiamond.repository;

import br.com.fiap.pizzariadiamond.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
