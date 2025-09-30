package com.shriSells.main.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id; // Maps to customer_id (SERIAL PRIMARY KEY)

    @Column(name = "email", unique = true, nullable = false)
    private String email; // Maps to email (VARCHAR(255) UNIQUE NOT NULL)

    @Column(name = "password")
    private String password; // Maps to password (VARCHAR(255), Nullable for OAuth)

    @Column(name = "name", nullable = false)
    private String name; // Maps to name (VARCHAR(255) NOT NULL)

    @Column(name = "auth_provider", nullable = false)
    private String authProvider; // Maps to auth_provider (VARCHAR(50) NOT NULL DEFAULT 'google')

    @Column(name = "provider_user_id")
    private String providerUserId; // Maps to provider_user_id (Google/GitHub unique ID)

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt; // Maps to created_at (TIMESTAMP DEFAULT CURRENT_TIMESTAMP)

    // Optional: Lifecycle hook for setting createdAt timestamp before persistence
    @PrePersist
    protected void onCreate() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }
}