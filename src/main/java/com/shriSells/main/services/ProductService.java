package com.shriSells.main.services;

import com.shriSells.main.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ProductService {
    // Correct way to initialize a list with a single item
    List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product(1, "Steamer", "Electronics", 100));
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}