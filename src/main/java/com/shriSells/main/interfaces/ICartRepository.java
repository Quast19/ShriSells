package com.shriSells.main.interfaces;

import com.shriSells.main.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepository extends JpaRepository<Cart,Long> {
}
