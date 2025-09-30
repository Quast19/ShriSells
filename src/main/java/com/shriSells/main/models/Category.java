package com.shriSells.main.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categories")
@Data
public class Category {
    // Maps to category_id SERIAL PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Matches SERIAL in PostgreSQ
    private Long category_id;

    // Maps to name VARCHAR(100) UNIQUE NOT NULL
    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    // --- Constructors ---
    public Category() {}

    public Category(String name) {
        this.name = name;
    }
}
