package com.example.assemble.service;

import com.example.assemble.dto.ProductDto;
import com.example.assemble.entity.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(ProductDto productDto);

    List<Product> getProducts();
}
