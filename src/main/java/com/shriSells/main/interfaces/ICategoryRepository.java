package com.shriSells.main.interfaces;

import com.shriSells.main.models.Category;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository  extends JpaRepository<Category, Long> {

}
