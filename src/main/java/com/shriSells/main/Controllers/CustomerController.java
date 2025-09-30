package com.shriSells.main.Controllers;

import com.shriSells.main.interfaces.ICustomerRepository;
import com.shriSells.main.models.Customer;
import com.shriSells.main.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("secure/Customer")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public List<Customer> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/me")
    public Customer findByMe(Authentication authentication){
        return (Customer) authentication.getPrincipal();
    }
}
