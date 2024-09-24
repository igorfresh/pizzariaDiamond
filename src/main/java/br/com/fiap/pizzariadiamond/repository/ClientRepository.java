package br.com.fiap.pizzariadiamond.repository;

import br.com.fiap.pizzariadiamond.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
