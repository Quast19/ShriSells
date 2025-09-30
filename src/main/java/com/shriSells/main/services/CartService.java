package com.shriSells.main.services;

import com.shriSells.main.interfaces.ICartRepository;
import com.shriSells.main.interfaces.ICartService;
import com.shriSells.main.models.Cart;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository repo;

    @Override
    public List<Cart> findAll(){
        return repo.findAll();
    };

    @Override
    public Optional<Cart> findById(Long id){
        return repo.findById(id);
    };

    @Override
    public Cart save(Cart cart)
    {
        return repo.save(cart);
    };

    @Override
    public void delete(Cart cart){
        repo.delete(cart);
    };
}
