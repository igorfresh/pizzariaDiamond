package br.com.fiap.pizzariadiamond.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pizza_order")
@Data
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @ToString.Exclude
    Client client;

    LocalDateTime date;

    @ManyToMany
    @ToString.Exclude
    List<Pizza> items;

    BigDecimal totalPrice;

    public BigDecimal calculateTotalPrice() {
        return items.stream()
                .map(Pizza::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @PrePersist
    @PreUpdate
    public void prePersist() {
        this.date = LocalDateTime.now();
        this.totalPrice = calculateTotalPrice();
    }

}
