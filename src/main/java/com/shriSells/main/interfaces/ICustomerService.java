package com.shriSells.main.interfaces;

import com.shriSells.main.models.Customer;
import java.util.List;
import java.util.Optional;
public interface ICustomerService {

    public Optional<List<Customer>> findByName(String name);
    public List<Customer> findAll();
    public Customer save(Customer customer);
    public void delete(Customer customer);
    public Optional<Customer> findBySub(String sub);
}
