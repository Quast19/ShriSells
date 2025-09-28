package com.shriSells.main.services;

import com.shriSells.main.interfaces.ICategoryRepository;
import com.shriSells.main.interfaces.ICategoryService;
import com.shriSells.main.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    ICategoryRepository repo;

    @Override
    public List<Category> getAllCategories() {
        return repo.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return  repo.findById(id);
    }

    @Override
    public Category saveCategory(Category category) {
        return repo.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        repo.deleteById(id);
    }
}
