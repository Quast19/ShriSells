package com.shriSells.main.Controllers;

import com.shriSells.main.models.Product;
import com.shriSells.main.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;
//    /('/products')
    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }


    @GetMapping("/count")
    //@RequestMapping("/count")
    public int countProducts(){
        return productService.numberOfProducts();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody long productId){
        productService.deleteProduct(productId);
    }
}
