package com.shriSells.main.interfaces;

import com.shriSells.main.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for the Product Entity.
 * Extends JpaRepository to inherit all standard CRUD operations (save, findAll, findById, etc.).
 * Parameters: <Entity Class, Primary Key Type>
 */
@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    /**
     * Custom finder method. Spring automatically implements this by looking for a Product
     * where the 'sku' field matches the given String.
     * This is required by the IProductService interface.
     */
    Product findBySku(String sku);
}
