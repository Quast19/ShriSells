package com.shriSells.main.dto;

import com.shriSells.main.models.Customer;
import lombok.Data;
import java.util.List;

@Data // Generates getters, setters, toString, equals, hashCode automatically
public class CustomerDetailsResponse {

    private String customerName;

    private Customer customer;

    // A list of items currently in the customer’s cart
    private List<?> cartItems;

    // A list of up to 3 recent products the customer ordered
    private List<?> recentProducts;

    // Category of each of those products (you can map these on the service side)
    private List<?> productCategories;
}
