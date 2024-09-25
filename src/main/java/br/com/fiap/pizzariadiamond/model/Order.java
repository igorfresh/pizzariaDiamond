package br.com.fiap.pizzariadiamond.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pizza_order")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "client_id", nullable = false) // Adicionei a coluna para o relacionamento com Client
    private Client client;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @ManyToMany
    @ToString.Exclude
    @JoinTable(
            name = "pizza_order_items", // Tabela de junção
            joinColumns = @JoinColumn(name = "pizza_order_id"), // Corrigido para corresponder ao seu SQL
            inverseJoinColumns = @JoinColumn(name = "pizza_id")
    )
    private List<Pizza> items = new ArrayList<>();

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

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
