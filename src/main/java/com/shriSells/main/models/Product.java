package com.shriSells.main.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private int productId;
    private String productName;
    private String productCategory;
    private int price;

    public Product() {
    }
}
