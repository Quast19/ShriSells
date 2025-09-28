package com.shriSells.main.services;

import com.shriSells.main.interfaces.IProductRepository;
import com.shriSells.main.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ProductService {
    // Correct way to initialize a list with a single item
    @Autowired
    IProductRepository repo;

    public ProductService(IProductRepository repo) {
        System.out.println("ProductService constructor");
    }

    public List<Product> getProducts() {
        return repo.findAll();
    }
    public int numberOfProducts() {
        return repo.findAll().size();
    }

    public Product saveProduct(Product product){
        return repo.save(product);
    }

    public void deleteProduct(long productId){
        repo.deleteById(productId);
    }
}