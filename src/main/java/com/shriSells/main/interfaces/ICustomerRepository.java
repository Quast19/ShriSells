package com.shriSells.main.interfaces;

import com.shriSells.main.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findByName(String name);
    Optional<Customer> findByProviderUserId(String providerUserId);
}
