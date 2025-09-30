package com.shriSells.main.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(
        name = "carts",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"customer_id", "product_id"})}
)
@Data
public class Cart {

    // Maps to cart_id SERIAL PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cart_id;

    @Column(name = "customer_id", nullable = false)
    private Long customer_id;

    @Column(name = "product_id", nullable = false)
    private Long product_id;

    // Maps to quantity INT NOT NULL CHECK (quantity > 0)
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    // --- Constructors ---
    public Cart() {}

    // Optional: validate quantity before insert/update
    @PrePersist
    @PreUpdate
    private void validateQuantity() {
        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
    }
}
