package com.example.assemble.serviceImpl;

import com.example.assemble.dto.CategoryDto;
import com.example.assemble.entity.Category;
import com.example.assemble.entity.Transaction;
import com.example.assemble.exception.ResourceNotFoundException;
import com.example.assemble.repository.CategoryRepository;
import com.example.assemble.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(CategoryDto categoryDto) {

        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(category.getDescription());
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if (!optionalCategory.isPresent()){
            throw new ResourceNotFoundException("Category with id " + id + " not found");
        }
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category updateCategory(Long id, Category category) {

        Category categoryInDb = categoryRepository.findById(id).get();

        if (Objects.nonNull(category.getName()) &&
        !"".equalsIgnoreCase(category.getName())){
            categoryInDb.setName(category.getName());
        }

        if (Objects.nonNull(category.getDescription()) &&
        !"".equalsIgnoreCase(category.getDescription())){
            categoryInDb.setDescription(category.getDescription());
        }
        return categoryRepository.save(categoryInDb);
    }

    @Override
    public void deleteCategoryById(Long id) {
       categoryRepository.deleteById(id);
    }

    @Override
    public List<List<Transaction>> findAllIncomesByCategory(Long categoryId) {
        return null;
    }

    @Override
    public Category findByName(String name) {

        return categoryRepository.findByName(name);
    }

}

