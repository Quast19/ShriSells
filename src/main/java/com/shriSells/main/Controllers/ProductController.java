package com.shriSells.main.Controllers;

import com.shriSells.main.models.Product;
import com.shriSells.main.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;
//    /('/products')
    @RequestMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
}
