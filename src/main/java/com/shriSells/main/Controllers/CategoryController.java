package com.shriSells.main.Controllers;

import com.shriSells.main.models.Category;
import com.shriSells.main.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(Long id){
        return categoryService.getCategoryById(id).orElse(null);
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @PutMapping
    public Category updateCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @DeleteMapping
    public void deleteCategory(@RequestBody Long id){
        categoryService.deleteCategory(id);
    }
}
