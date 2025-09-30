package com.shriSells.main.interfaces;

import com.shriSells.main.models.Category;
import java.util.List;
import java.util.Optional;
public interface ICategoryService {
    List<Category> getAllCategories();

    Optional<Category> getCategoryById(Long id);

    Category saveCategory(Category category);

    void deleteCategory(Long id);

}
