package com.shriSells.main.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * JPA Entity representing the 'products' table in the database.
 * Uses Lombok for boilerplate code (getters, setters, constructors).
 */
@Entity
@Table(name = "products")
@Data
public class Product {

    // Maps to product_id SERIAL PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    // Maps to sku VARCHAR(100) UNIQUE NOT NULL
    @Column(name = "sku", unique = true, nullable = false, length = 100)
    private String sku;

    // Maps to name VARCHAR(255) NOT NULL
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    // Maps to description TEXT. Using String in Java maps fine to TEXT in PostgreSQL.
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    // Maps to price DECIMAL(10,2) NOT NULL
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    // Maps to stock INT NOT NULL (CHECK constraint is handled by the database)
    @Column(name = "stock", nullable = false)
    private Integer stock;

    // Maps to category_id INT (Foreign Key to categor ies table)
    // We use the column name directly here until the Category entity is fully wired up using @ManyToOne.
    @Column(name = "category_id")
    private Long categoryId;

    public Product() {

    }
}
