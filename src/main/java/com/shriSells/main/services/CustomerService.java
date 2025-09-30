package com.shriSells.main.services;

import com.shriSells.main.interfaces.ICustomerRepository;
import com.shriSells.main.interfaces.ICustomerService;
import com.shriSells.main.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // Import the @Service annotation

import java.util.List;
import java.util.Optional;

@Service // Mark this class as a Spring Service component
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerRepository repo;

    /**
     * Finds customers by their name.
     * @param name The name to search for.
     * @return An Optional containing a list of matching customers, or empty if no matches.
     */
    @Override
    public Optional<List<Customer>> findByName(String name) {
        // Find by name in the repository.
        // Note: The actual repository method should be implemented to handle the List return.
        List<Customer> customers = repo.findByName(name);
        return Optional.ofNullable(customers.isEmpty() ? null : customers);
    }

    @Override
    public Optional<Customer> findBySub(String sub){
        return repo.findByProviderUserId(sub);
    }
    /**
     * Retrieves all customers from the database.
     * @return A list of all customers.
     */
    @Override
    public List<Customer> findAll() {
        return repo.findAll();
    }

    /**
     * Saves a new customer or updates an existing one.
     * @param customer The customer object to save.
     * @return The saved/updated customer object.
     */
    @Override
    public Customer save(Customer customer) {
        return repo.save(customer);
    }

    /**
     * Deletes a customer entity.
     * @param customer The customer object to delete.
     */
    @Override
    public void delete(Customer customer) {
        repo.delete(customer);
    }
}