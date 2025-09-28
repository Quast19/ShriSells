package com.shriSells.main.services;

import com.shriSells.main.interfaces.IProductRepository;
import com.shriSells.main.interfaces.IProductService;
import com.shriSells.main.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    // Correct way to initialize a list with a single item
    @Autowired
    IProductRepository repo;

    public ProductService(IProductRepository repo) {
        System.out.println("ProductService constructor");
    }

    public List<Product> getProducts() {
        return repo.findAll();
    }
    public Optional<Product> getProductById(Long id){
        return repo.findById(id);
    }

    public int numberOfProducts() {
        return repo.findAll().size();
    }

    public Product saveProduct(Product product){
        return repo.save(product);
    }

    @Override
    public void deleteProduct(Long id){
        repo.deleteById(id);
    }
}