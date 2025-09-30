package com.shriSells.main.interfaces;

import com.shriSells.main.models.Cart;

import java.util.List;
import java.util.Optional;
public interface ICartService {
    public  List<Cart> findAll();
    Optional<Cart> findById(Long id);
    public Cart save(Cart cart);
    public void delete(Cart cart);

}
