package com.example.assemble.service;

import com.example.assemble.dto.CategoryDto;
import com.example.assemble.entity.Category;
import com.example.assemble.entity.Transaction;

import java.util.List;

public interface CategoryService {


    List<Category> findAllCategories();

    Category saveCategory(CategoryDto categoryDto);

    Category findById(Long id);

    Category updateCategory(Long id, Category category);

    void deleteCategoryById(Long id);

    List<List<Transaction>> findAllIncomesByCategory(Long categoryId);
}
