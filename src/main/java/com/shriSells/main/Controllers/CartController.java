package com.shriSells.main.Controllers;

import com.shriSells.main.models.Cart;
import com.shriSells.main.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cart")
public class CartController {

    @Autowired
    CartService cartService;

    public List<Cart> getCarts(){
        return cartService.findAll();
    }

    @GetMapping("/{Id}")
    public Cart getCarts(@PathVariable("Id") Long Id){
        return cartService.findById(Id).orElse(null);
    }

    @PostMapping
    public Cart save(@RequestBody Cart cart){
        return cartService.save(cart);
    }

    @PutMapping
    public Cart update(@RequestBody Cart cart){
        return cartService.save(cart);
    }

    @DeleteMapping
    public void delete(@RequestBody Cart cart){
        cartService.delete(cart);
    }
}

