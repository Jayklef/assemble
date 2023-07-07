package com.example.assemble.service;

import com.example.assemble.dto.ProductDto;
import com.example.assemble.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    Product saveProduct(ProductDto productDto);

    List<Product> getProducts();

    Product getProduct(Long id);

    void deleteById(Long id);

    Product updateProduct(Long id, Product product);

    Product findByName(String name);

    Page<Product> findProductPagination(Integer pageNumber, Integer pageSize);
}
