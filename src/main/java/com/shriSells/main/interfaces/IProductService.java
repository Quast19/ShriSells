package com.shriSells.main.interfaces;

import com.shriSells.main.models.Product;
import java.util.List;
import java.util.Optional;

/**
 * Defines the service contract for Product-related business operations.
 */
public interface IProductService {

    /** Saves a new Product or updates an existing one. */
    Product saveProduct(Product product);

    /** Retrieves all Products. */
    List<Product> getProducts();

    /** Retrieves a Product by its ID. */
    Optional<Product> getProductById(Long id);

//    /** Retrieves a Product by its unique SKU. */
//    Optional<Product> getProductBySku(String sku); // <-- New method for SKU

    /** Deletes a Product by its ID. */
    void deleteProduct(Long id);
}
